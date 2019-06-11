package org.sid.web;

import java.util.Collection;
import java.util.List;

import org.sid.dao.AbonnementRepository;
import org.sid.dao.MatiereRepository;
import org.sid.entities.Abonnement;
import org.sid.entities.Commentaire;
import org.sid.entities.Matiere;
import org.sid.entities.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AbonnementController {

	@Autowired
	AbonnementRepository abonnementRepository;
	
	@Autowired
	MatiereRepository matiereRepository;
	@RequestMapping(value="/abonnements",method=RequestMethod.GET)
	public List<Abonnement> getAbs()
	{
		return abonnementRepository.findAll();
	}
	
	@RequestMapping(value="/abonnements/{id}",method=RequestMethod.GET)
    public Matiere getMatiere(@PathVariable int id){
	
		Abonnement ab=abonnementRepository.findOne(id);
		
		 return  ab.getMatiere();
 

	}
}
