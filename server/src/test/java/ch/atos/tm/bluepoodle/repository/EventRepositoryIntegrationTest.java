package ch.atos.tm.bluepoodle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.domain.Event;

public class EventRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Test
	public void savePublisher() {
		Event event = new Event();
		eventRepository.save(event);
	}
}
