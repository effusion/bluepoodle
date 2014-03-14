package ch.atos.tm.bluepoodle.service;

import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.AbstractIntegrationTest;
import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.EventType;
import ch.atos.tm.bluepoodle.domain.Publisher;
import ch.atos.tm.bluepoodle.repository.EventRepository;
import ch.atos.tm.bluepoodle.repository.EventTypeRepository;
import ch.atos.tm.bluepoodle.repository.LocationRepository;
import ch.atos.tm.bluepoodle.repository.PublisherRepository;

public class PublisherServiceIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private EventTypeRepository eventTypeRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private EventRepository eventRepository;
	private Publisher publisher;
	
	@BeforeClass
	public void setUp(){
		publisher = publisherRepository.findOne(2L);
	}
	
	@Test
	public void findAllEventsForOnePublisher(){
		List<Event> events = publisherService.findAllEvents(publisher);
		assertEquals(2,events.size());
	}
	
	@Test
	public void modifyEvent(){
		List<Event> events = publisherService.findAllEvents(publisher);
		Event event = events.get(0);
		event.setLocation(locationRepository.findOne(4L));
		publisherService.save(event);
	}
	
	@Test
	public void findAllEventTypeForOnePublisher(){
		List<EventType> eventsTypes = publisherService.findAllEventTypes(publisher);
		assertEquals(2,eventsTypes.size());
	}
	
	@Test
	public void deleteEvent(){
		publisherService.deleteEvent(eventRepository.findOne(3L));
		assertNull(eventRepository.findOne(3L));
	}
	
	
}
