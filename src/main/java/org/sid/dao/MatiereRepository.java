package org.sid.dao;

import org.sid.entities.Matiere; 
import org.sid.entities.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {
	
	@Query("select c from Matiere c where c.nomMatiere like :x ")
	public Page<Matiere> chercherParNom(@Param("x") String mc,Pageable pageable);
}
