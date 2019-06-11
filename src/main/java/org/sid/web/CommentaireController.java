package org.sid.web;

import java.util.Collection; 
import java.util.List;

import org.sid.dao.CommentaireRepository;
import org.sid.dao.PublicationRepository;
import org.sid.entities.Commentaire;
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
public class CommentaireController {

	@Autowired
	CommentaireRepository commentaireRepository;
	@Autowired
PublicationRepository publicationRepository ;
	
	@RequestMapping(value="/commentaires",method=RequestMethod.GET)
	public List<Commentaire> getComs()
	{
		return commentaireRepository.findAll();
	}
	
	@RequestMapping(value="/commentaires/{id}",method=RequestMethod.GET)
    public Commentaire getComss(@PathVariable int id){
	
		
		
		return commentaireRepository.findOne(id);
		   
 

	}
	
	@RequestMapping(value="/commentaire/ajout",method=RequestMethod.POST)
	public Commentaire save(@RequestBody Commentaire p)
	{
		return commentaireRepository.save(p);
	}
	
	@RequestMapping(value="/commentaire/{id}",method=RequestMethod.DELETE)
    public void deleteCommentaire(@PathVariable int id){

		commentaireRepository.delete(id);

	}
	@RequestMapping(value="/commentaire/update/{id}",method=RequestMethod.PUT)
	public Commentaire save(@PathVariable int id,	@RequestBody Commentaire p)
	{    p.setId_commentaire(id);
		return commentaireRepository.save(p);
	}
}
