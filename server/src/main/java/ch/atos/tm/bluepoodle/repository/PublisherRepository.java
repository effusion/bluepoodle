package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
	List<Publisher> findByLastName(String lastName);	
	List<Publisher> findByFirstName(String firstName);	
	List<Publisher> findByEmail(String email);	
	List<Publisher> findByUserName(String username);
}
