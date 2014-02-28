package ch.atos.tm.bluepoodle.service;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.AbstractIntegrationTest;
import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.Publisher;
import ch.atos.tm.bluepoodle.repository.PublisherRepository;

public class PublisherServiceIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Test
	public void findAllEventsForOnePublisher(){
		Publisher publisher = publisherRepository.findOne(2L);
		List<Event> events = publisherService.findAllEvents(publisher);
		assertEquals(2,events.size());
	}
}
