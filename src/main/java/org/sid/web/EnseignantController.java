package org.sid.web;

import java.util.List;

import org.sid.dao.EnseignantRepository;
import org.sid.entities.Enseignant;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EnseignantController {

	@Autowired
	private EnseignantRepository enseignantRepository;
	

	@RequestMapping(value="/enseignant",method=RequestMethod.GET)
	public List<Enseignant> getUsers(){
		
return enseignantRepository.ge();
	}
	
}
