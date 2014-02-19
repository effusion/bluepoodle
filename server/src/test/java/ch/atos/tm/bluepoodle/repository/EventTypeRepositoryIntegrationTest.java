package ch.atos.tm.bluepoodle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.domain.EventType;

public class EventTypeRepositoryIntegrationTest extends AbstractIntegrationTest{
	
	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Test
	public void savePublisher() {
		EventType eventType = new EventType();
		eventTypeRepository.save(eventType);
	}
}
