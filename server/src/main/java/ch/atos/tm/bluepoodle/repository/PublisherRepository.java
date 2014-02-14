package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
	
	@Query("select p from Publisher p where p.lastName = ?1")
	List<Publisher> findPublisherByLastName(String lastName);
}
