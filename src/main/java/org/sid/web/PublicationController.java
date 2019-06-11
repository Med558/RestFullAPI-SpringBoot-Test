package org.sid.web;

import java.util.List; 

import org.sid.dao.PublicationRepository;
import org.sid.entities.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class PublicationController {

	@Autowired
	private PublicationRepository publicationRepository;
	
	
	
	@RequestMapping(value="/publications",method=RequestMethod.GET)
	public List<Publication> getPublications()
	{
		return publicationRepository.findAll();
	}
	
	
	@RequestMapping(value="/publications/{id}",method=RequestMethod.GET)
    public Publication getPublication(@PathVariable int id){

		return publicationRepository.findOne(id);

	}
	@RequestMapping(value="/publication/ajout",method=RequestMethod.POST)
	public Publication save(@RequestBody Publication p)
	{
		return publicationRepository.save(p);
	}
	@RequestMapping(value="/publication/{id}",method=RequestMethod.DELETE)
    public void deletePublication(@PathVariable int id){

		publicationRepository.delete(id);

	}
	
	@RequestMapping(value="/publication/update/{id}",method=RequestMethod.PUT)
	public Publication save(@PathVariable int id,	@RequestBody Publication p)
	{    p.setId_pub(id);
		return publicationRepository.save(p);
	}
}
