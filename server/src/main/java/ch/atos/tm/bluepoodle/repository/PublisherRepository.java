package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import ch.atos.tm.bluepoodle.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>, QueryDslPredicateExecutor<Publisher> {
	List<Publisher> findByLastName(String lastName);	
	List<Publisher> findByFirstName(String firstName);	
	List<Publisher> findByEmail(String email);	
	List<Publisher> findByUserName(String username);
}
