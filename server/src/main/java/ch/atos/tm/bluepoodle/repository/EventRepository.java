package ch.atos.tm.bluepoodle.repository;

import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
