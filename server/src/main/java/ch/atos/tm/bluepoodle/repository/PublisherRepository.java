package ch.atos.tm.bluepoodle.repository;

import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
	
}
