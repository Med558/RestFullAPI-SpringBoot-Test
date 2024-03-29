package org.sid;

import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date; 
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.sid.entities.Abonnement;
import org.sid.entities.AppRole;
import org.sid.entities.Commentaire;
import org.sid.entities.Enseignant;
import org.sid.entities.Matiere;
import org.sid.entities.Publication;
import org.sid.entities.User ;
import org.sid.service.AccountService;
import org.sid.service.StorageService;
//import org.sid.metier.IUserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.sid.dao.AbonnementRepository;
import org.sid.dao.AppRoleRepository;
import org.sid.dao.CommentaireRepository;
import org.sid.dao.EnseignantRepository;
import org.sid.dao.MatiereRepository;
import org.sid.dao.PublicationRepository;
import org.sid.dao.UserRepository;

@SpringBootApplication
public class PfaApplication  implements CommandLineRunner{
	@Autowired
	 private EnseignantRepository enseignantRepository;
	@Autowired
	private UserRepository userRepository ;
	@Autowired
private PublicationRepository publicationRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	 @Autowired
	private AbonnementRepository abonnementRepository;
	
	 @Autowired
	 private CommentaireRepository commentaireRepository;
	 
	 @Autowired
	 private AppRoleRepository appRoleRepository;
	
	 @Autowired
	 private AccountService accountService;
	 
	 @Resource
	  StorageService storageService;
	public static void main(String[] args){
		SpringApplication.run(PfaApplication.class, args);
	
	}
  
	public void run(String... arg0) throws Exception {	
		//DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
	//	User u1=userRepository.save(new User("Hachana","Fethi","hach@gmail.com","Monastir",28662886));
		Matiere m1=new Matiere("J2EE");
		matiereRepository.save(m1);	
		//Matiere m2=matiereRepository.save(new Matiere("PHP"));
		//Enseignant u3=enseignantRepository.save(new Enseignant("Hamma","BENHNIA","hamma@gmail.com","JSK",5583859));
			Enseignant u4=new Enseignant();
			u4.setMatierens(m1);

			/*Enseignant u5=new Enseignant("oko", "pl	", "ok@gmail.com", "Maroc", 516515);
User u1=userRepository.save(new User("hamma", "BENHNIA", "hamma@gmail.com", "JSK", 23323232));

enseignantRepository.save(u4);
enseignantRepository.save(u5);
publicationRepository.save(new Publication(new Date(), "Bonsoir les amis ", u4, m1));
publicationRepository.save(new Publication(new Date(), "COUCOU les amis ", u4, m1));
publicationRepository.save(new Publication(new Date(), "COUCOU les amis aa bb ss tt", u4, m1));


Commentaire com= commentaireRepository.save(new Commentaire("cc", u1, pub1));
Commentaire com2= commentaireRepository.save(new Commentaire("oui oui", u1, pub1));
Commentaire com3= commentaireRepository.save(new Commentaire("lol", u4, pub1));

Abonnement ab1=abonnementRepository.save(new Abonnement(u1, m1));*/

//Enseignant u5=enseignantRepository.save(new Enseignant("HACHANA ", "HACHANA YI", "HACHANA @gmail.com", "Maroc", 51651));
//m1.getEnseignants().add(u4);

		accountService.save(new AppRole(1,"USER"));
		accountService.save(new AppRole(2,"ENSEIGNANT"));
		accountService.save(new AppRole(3,"ADMIN"));
		
		accountService.saveUser("hachana", "1234", "1234");
		accountService.saveUser("med", "1234", "1234");
		accountService.saveUser("mouheddine", "1234", "1234");
        accountService.addRoleToUser("hachana", "ADMIN");
        accountService.addRoleToUser("med", "USER");
        accountService.addRoleToUser("mouheddine", "ENSEIGNANT");
        

		System.out.println("---------------------------------------------------- 0");

		
		System.out.println("---------------------------------------------------- 1");
	

		System.out.println("---------------------------------------------------- 2");
		
		
	
		//m1.getEnseignants().add(u4);
System.out.println("---------------------------------------------------- 3");
System.out.println("---------------------------------------------------- 4");

	 	System.out.println();

	 	storageService.deleteAll();
	    storageService.init();

		//Publication pub1=publicationRepository.save(new Publication(new Date(), "contenu", u1,m1));
//Abonnement ab1=abonnementRepository.save(new Abonnement(u1, m1));	
/*User u2=userRepository.save(new Enseignant("Youssfi", "Mohamed", "youssfi@gmail.com", "Maroc", 65998,df.parse("12/12/1983"), "med.jpg", "hach",m1));
Publication pub1=publicationRepository.save(new Publication(new Date(), "contenu", u2,m1));
Abonnement ab1=abonnementRepository.save(new Abonnement(u1.getId(), m1.getId_matiere()));
iUserMetier.abonner(u3, m2);
iUserMetier.commenter(u3, pub1, "HELLO");
*/

	}
@Bean
	BCryptPasswordEncoder getBCPE(){
		
		return new BCryptPasswordEncoder();
	}
	

}