package ch.bluepoodle.server.service;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Publisher;
import ch.bluepoodle.domain.Subscriber;
import ch.bluepoodle.server.AbstractIntegrationTest;
import ch.bluepoodle.server.repository.EventRepository;
import ch.bluepoodle.server.repository.EventTypeRepository;
import ch.bluepoodle.server.repository.LocationRepository;
import ch.bluepoodle.server.repository.PublisherRepository;
import ch.bluepoodle.server.repository.SubscriberRepository;
import ch.bluepoodle.server.service.PublisherService;

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
	@Autowired
	private SubscriberRepository subscriberRepository;
	private Publisher publisher;
	
	private static Long PUBLISHER_KUHTZ = 2L;
	
	@BeforeMethod
	public void beforeMethod(){
		publisher = publisherRepository.findOne(PUBLISHER_KUHTZ);
	}
	
	@Test
	public void findAllEventsForOnePublisher(){
		List<Event> events = publisherService.findAllEvents(publisher.getId());
		assertEquals(2,events.size());
	}
	
	@Test
	public void modifyEvent(){
		List<Event> events = publisherService.findAllEvents(publisher.getId());
		int oldEventSize = events.size();
		Event event = events.get(0);
		event.setLocation(locationRepository.findOne(4L));
		publisherService.updateEvent(event);
		events = publisherService.findAllEvents(publisher.getId());
		assertEquals(oldEventSize,events.size());
	}
	
	@Test
	public void findAllEventTypeForOnePublisher(){
		List<EventType> eventsTypes = publisherService.findAllEventTypes(publisher.getId());
		assertEquals(2,eventsTypes.size());
	}
	
	@Test
	public void deleteEvent(){
		publisherService.deleteEvent(eventRepository.findOne(3L).getId(), publisher.getId());
		assertNull(eventRepository.findOne(3L));
	}
	
	@Test
	public void createEvent(){
		Event event = new Event();
		EventType eventType = eventTypeRepository.findOne(1L);
		event.setEventType(eventType);
		event.setPublisher(publisher);
		String name = "JavaLand";
		event.setName(name);
		event.setLocation(locationRepository.findOne(4L));
		event = publisherService.createEvent(event);
		assertEquals(event.getName(),name);
		publisherService.deleteEvent(event.getId(), publisher.getId());
	}
	
	@Test
	public void findAllSubscribersForEvent(){
		List<Event> events = publisherService.findAllEvents(publisher.getId());
		Event event = events.get(0);
		List<Subscriber> subscribers = publisherService.findAllSubscribers(event.getId());
		assertFalse(subscribers.isEmpty());
		Subscriber excpectedSubscriber = subscriberRepository.findOne(4L);
		assertTrue(subscribers.contains(excpectedSubscriber));
	}
	
	@Test
	public void addSubscriberToEvent(){
		List<Event> events = publisherService.findAllEvents(publisher.getId());
		Event event = events.get(0);
		Subscriber subscriber = subscriberRepository.findOne(3L);
		List<Subscriber> subscribers = publisherService.findAllSubscribers(event.getId());
		int subscriberCount = subscribers.size();
		publisherService.addSubscriberToEvent(event.getId(),subscriber.getId(), "Geh mal hin und lern was!");
		assertEquals(publisherService.findAllSubscribers(event.getId()).size(),subscriberCount+1);
	}
	@Test(expectedExceptions=ConstraintViolationException.class)
	public void checkNullConstraintFindAllEvents(){
		publisherService.findAllEvents(null);
	}
	
	@Test(expectedExceptions=ConstraintViolationException.class)
	public void checkNullConstraintCreateEvent(){
		publisherService.createEvent(null);
	}
	
	@Test(expectedExceptions=ConstraintViolationException.class)
	public void checkNullConstraintUpdateEvent(){
		publisherService.updateEvent(null);
	}
	
	@Test(expectedExceptions=ConstraintViolationException.class)
	public void checkNullConstraintFindAllEventTyps(){
		publisherService.findAllEventTypes(null);
	}
	
	@Test(expectedExceptions=ConstraintViolationException.class)
	public void checkNullConstraintFindAllSubscribers(){
		publisherService.findAllSubscribers(null);
	}
	
	@Test
	public void checkNullConstraintsDeleteEvent(){
		try{
			publisherService.deleteEvent(null, 0L);
			fail();
		}catch(ConstraintViolationException e1){/*OK*/}
		
		try{
			publisherService.deleteEvent(0L, null);
			fail();
		}catch(ConstraintViolationException e2){/*OK*/}
	}
	
	@Test
	public void checkNullConstraintsAddSubscriberToEvent(){
		try{
			publisherService.addSubscriberToEvent(null, 0L, "");
			fail();
		}catch(ConstraintViolationException e1){/*OK*/}
		
		try{
			publisherService.addSubscriberToEvent(0L, null, "");
			fail();
		}catch(ConstraintViolationException e2){/*OK*/}
	}
}
