package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.atos.tm.bluepoodle.domain.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
	List<Location> findByName(String name);
	List<Location> findByDescription(String description);
}
