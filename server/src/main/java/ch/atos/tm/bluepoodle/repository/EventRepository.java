package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import ch.atos.tm.bluepoodle.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> , QueryDslPredicateExecutor<Event>{
	List<Event> findByName(String name);
}
