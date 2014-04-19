package ch.bluepoodle.service;


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

import ch.bluepoodle.AbstractIntegrationTest;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Publisher;
import ch.bluepoodle.domain.Subscriber;
import ch.bluepoodle.repository.EventRepository;
import ch.bluepoodle.repository.EventTypeRepository;
import ch.bluepoodle.repository.LocationRepository;
import ch.bluepoodle.repository.PublisherRepository;
import ch.bluepoodle.repository.SubscriberRepository;

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
		List<Event> events = publisherService.findAllEvents(publisher);
		assertEquals(2,events.size());
	}
	
	@Test
	public void modifyEvent(){
		List<Event> events = publisherService.findAllEvents(publisher);
		int oldEventSize = events.size();
		Event event = events.get(0);
		event.setLocation(locationRepository.findOne(4L));
		publisherService.updateEvent(event);
		events = publisherService.findAllEvents(publisher);
		assertEquals(oldEventSize,events.size());
	}
	
	@Test
	public void findAllEventTypeForOnePublisher(){
		List<EventType> eventsTypes = publisherService.findAllEventTypes(publisher);
		assertEquals(2,eventsTypes.size());
	}
	
	@Test
	public void deleteEvent(){
		publisherService.deleteEvent(eventRepository.findOne(3L), publisher);
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
		publisherService.deleteEvent(event, publisher);
	}
	
	@Test
	public void findAllSubscribersForEvent(){
		List<Event> events = publisherService.findAllEvents(publisher);
		Event event = events.get(0);
		List<Subscriber> subscribers = publisherService.findAllSubscribers(event);
		assertFalse(subscribers.isEmpty());
		Subscriber excpectedSubscriber = subscriberRepository.findOne(4L);
		assertTrue(subscribers.contains(excpectedSubscriber));
	}
	
	@Test
	public void addSubscriberToEvent(){
		List<Event> events = publisherService.findAllEvents(publisher);
		Event event = events.get(0);
		Subscriber subscriber = subscriberRepository.findOne(3L);
		List<Subscriber> subscribers = publisherService.findAllSubscribers(event);
		int subscriberCount = subscribers.size();
		publisherService.addSubscriberToEvent(event,subscriber, "Geh mal hin und lern was!");
		assertEquals(publisherService.findAllSubscribers(event).size(),subscriberCount+1);
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
			publisherService.deleteEvent(null, publisher);
			fail();
		}catch(ConstraintViolationException e1){/*OK*/}
		
		try{
			publisherService.deleteEvent(new Event(), null);
			fail();
		}catch(ConstraintViolationException e2){/*OK*/}
	}
	
	@Test
	public void checkNullConstraintsAddSubscriberToEvent(){
		try{
			publisherService.addSubscriberToEvent(null, new Subscriber(), "");
			fail();
		}catch(ConstraintViolationException e1){/*OK*/}
		
		try{
			publisherService.addSubscriberToEvent(new Event(), null, "");
			fail();
		}catch(ConstraintViolationException e2){/*OK*/}
	}
}
