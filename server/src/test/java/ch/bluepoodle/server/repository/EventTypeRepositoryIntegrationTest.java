package ch.bluepoodle.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.server.AbstractIntegrationTest;
import ch.bluepoodle.server.repository.EventTypeRepository;

@Transactional
public class EventTypeRepositoryIntegrationTest extends AbstractIntegrationTest{
	
	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Test
	public void saveEventType() {
		EventType eventType = new EventType();
		eventType.setName("Bootcamp");
		eventTypeRepository.save(eventType);
	}
	
}
