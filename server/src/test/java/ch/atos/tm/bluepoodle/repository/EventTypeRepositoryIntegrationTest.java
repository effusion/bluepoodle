package ch.atos.tm.bluepoodle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.AbstractIntegrationTest;
import ch.atos.tm.bluepoodle.domain.EventType;

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
