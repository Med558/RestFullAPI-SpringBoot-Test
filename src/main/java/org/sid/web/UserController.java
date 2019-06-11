package org.sid.web;

import java.util.Collection;
import java.util.List;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Abonnement;
import org.sid.entities.AppRole;
import org.sid.entities.Commentaire;
import org.sid.entities.Matiere;
import org.sid.entities.Publication;
import org.sid.entities.User;
import org.sid.service.AccountService;
import org.sid.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
private UserRepository userRepository;	
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MailService notificationService;

	
	
	@RequestMapping(value="/profil",method=RequestMethod.GET)

	public User findprofil(
			@RequestParam(name="username",defaultValue="") String username)
{
	return userRepository.findprofil("%"+username+"%");
	}
	/*@RequestMapping(value="/updateprofil",method=RequestMethod.PUT)
	public void updateProfil(@RequestParam(name="nom",defaultValue="")String nom,@RequestParam(name="prenom",defaultValue="")String prenom,@RequestParam(name="email",defaultValue="")String email,@RequestParam(name="adresse",defaultValue="")String adresse,@RequestParam(name="tel",defaultValue="")int tel,@RequestParam(name="username",defaultValue="")String username){
		userRepository.updateProfil("%"+nom+"%", "%"+prenom+"%", "%"+email+"%", "%"+adresse+"%", tel, "%"+username+"%");
	}*/
	@RequestMapping(value="/profilupdate/{username}",method=RequestMethod.PUT)

	public User updateProfil(@PathVariable String username,	@RequestBody User u){
		User p = userRepository.findprofil("%"+username+"%");
		p.setNom(u.getNom());
		p.setPrenom(u.getPrenom());
		p.setAdresse(u.getAdresse());
		p.setEmail(u.getEmail());
		p.setTel(u.getTel());
		return userRepository.save(p);
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> getUsers(){
		
	
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public User getUser(@PathVariable int id){

		return userRepository.findOne(id);

	}
	
	@RequestMapping(value="/user/ajout",method=RequestMethod.POST)
	public User save(@RequestBody User p)
	{  try {
		notificationService.sendEmail(p.getEmail(),p.getUsername(),p.getPassword());
	} catch (MailException mailException) {
		System.out.println(mailException);
	}
		
		p.setPassword(bCryptPasswordEncoder.encode(p.getPassword()));
			
		  userRepository.save(p);
		  accountService.addRoleToUser(p.getUsername(),"USER");
		  return p;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public User register(@RequestBody UserForm userForm)
	{
		return accountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
	}
	
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){

		userRepository.delete(id);

	}
	
	@RequestMapping(value="/user/update/{id}",method=RequestMethod.PUT)
	public User save(@PathVariable int id,	@RequestBody User p)
	{    p.setId(id);
		return userRepository.save(p);
	}
	
	@RequestMapping(value="/user/abs/{id}",method=RequestMethod.GET)
    public Collection<Abonnement> getAbs(@PathVariable int id){
	
		
		
		 User u=userRepository.findOne(id);
		 return  u.getAbs();
 

	}
	
	@RequestMapping(value="/roles",method=RequestMethod.GET)
	public List<AppRole> getRoles(){
		return appRoleRepository.findAll();
	}
	@RequestMapping(value="/userens",method=RequestMethod.POST)
	public User ajoutEns(User user){
		User u=new User();
		u.setNom(user.getNom());
		u.setPrenom(user.getPrenom());
		u.setUsername(user.getUsername());
		u.setAdresse(user.getAdresse());
		u.setTel(user.getTel());
		u.setEmail(user.getEmail());
		u.setMatieres(user.getMatieres());
		u.setActived(true);
		
		
		//u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		//  accountService.addRoleToUser(u.getUsername(),"ENSEIGNANT");
		return userRepository.save(u);

		
	}
}

class UserForm {
	private String username;
	private String password;
	private String confirmedPassword;
	
	public UserForm(String username, String password, String confirmedPassword) {
		super();
		this.username = username;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
}
