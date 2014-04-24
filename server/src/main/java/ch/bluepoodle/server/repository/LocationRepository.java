package ch.bluepoodle.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.bluepoodle.domain.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
	List<Location> findByName(String name);
	List<Location> findByDescription(String description);
}
