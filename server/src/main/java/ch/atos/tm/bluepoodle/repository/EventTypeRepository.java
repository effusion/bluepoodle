package ch.atos.tm.bluepoodle.repository;

import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.EventType;

public interface EventTypeRepository extends CrudRepository<EventType, Long> {

}
