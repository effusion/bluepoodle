package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import ch.atos.tm.bluepoodle.domain.EventType;

public interface EventTypeRepository extends JpaRepository<EventType, Long>, QueryDslPredicateExecutor<EventType> {
	List<EventType> findByName(String name);
	List<EventType> findByDescription(String description);
}
