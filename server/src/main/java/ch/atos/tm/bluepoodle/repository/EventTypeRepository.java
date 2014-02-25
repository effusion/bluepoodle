package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.EventType;

public interface EventTypeRepository extends CrudRepository<EventType, Long> {
	List<EventType> findByName(String name);
	List<EventType> findByDescription(String description);
}
