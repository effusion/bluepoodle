package ch.bluepoodle.service;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.bluepoodle.AbstractIntegrationTest;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Publisher;
import ch.bluepoodle.repository.EventRepository;
import ch.bluepoodle.repository.EventTypeRepository;
import ch.bluepoodle.repository.LocationRepository;
import ch.bluepoodle.repository.PublisherRepository;
import ch.bluepoodle.service.PublisherService;

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
	
	@Test
	public void findAllEventsForOnePublisher(){
		publisher = publisherRepository.findOne(2L);
		List<Event> events = publisherService.findAllEvents(publisher);
		assertEquals(2,events.size());
	}
	
	@Test
	public void modifyEvent(){
		publisher = publisherRepository.findOne(2L);
		List<Event> events = publisherService.findAllEvents(publisher);
		int oldEventSize = events.size();
		Event event = events.get(0);
		event.setLocation(locationRepository.findOne(4L));
		publisherService.update(event);
		events = publisherService.findAllEvents(publisher);
		assertEquals(oldEventSize,events.size());
	}
	
	@Test
	public void findAllEventTypeForOnePublisher(){
		publisher = publisherRepository.findOne(2L);
		List<EventType> eventsTypes = publisherService.findAllEventTypes(publisher);
		assertEquals(2,eventsTypes.size());
	}
	
	@Test
	public void deleteEvent(){
		publisherService.deleteEvent(eventRepository.findOne(3L), publisherRepository.findOne(2L));
		assertNull(eventRepository.findOne(3L));
	}
	
	@Test
	public void createEvent(){
		Event event = new Event();
		EventType eventType = eventTypeRepository.findOne(1L);
		event.setEventType(eventType);
		event.setName("JavaLand");
	}
}
