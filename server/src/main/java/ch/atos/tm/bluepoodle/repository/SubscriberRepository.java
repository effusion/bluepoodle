package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.Subscriber;

public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
	List<Subscriber> findByLastName(String lastName);
	List<Subscriber> findByFirstName(String firstName);
	List<Subscriber> findByEmail(String email);
	List<Subscriber> findByUserName(String username);
}
