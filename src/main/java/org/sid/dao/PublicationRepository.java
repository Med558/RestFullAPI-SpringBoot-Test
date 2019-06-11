package org.sid.dao;

import org.sid.entities.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface PublicationRepository extends JpaRepository<Publication, Integer>{
	

}
