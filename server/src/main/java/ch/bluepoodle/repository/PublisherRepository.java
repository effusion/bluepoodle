package ch.bluepoodle.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import ch.bluepoodle.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>, QueryDslPredicateExecutor<Publisher> {
	List<Publisher> findByLastName(String lastName);	
	List<Publisher> findByFirstName(String firstName);	
	List<Publisher> findByEmail(String email);	
	List<Publisher> findByUserName(String username);
}
