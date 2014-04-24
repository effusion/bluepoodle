package ch.bluepoodle.server.service;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.Subscriber;
import ch.bluepoodle.server.AbstractIntegrationTest;
import ch.bluepoodle.server.repository.EventRepository;
import ch.bluepoodle.server.repository.SubscriberRepository;
import ch.bluepoodle.server.service.SubscriberService;

public class SubscriberServiceIntegrationTest extends AbstractIntegrationTest {
	@Autowired
	private SubscriberService subscriberService;
	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired
	private EventRepository eventRepository;
	private Subscriber subscriber;
	private Event event;
	
	@BeforeMethod
	public void beforeClass(){
		subscriber = subscriberRepository.findOne(1L);
		event = eventRepository.findOne(1L);	
	}
	
	@Test
	public void findAllEventsForOneSubscriber(){
		List<Event> events = subscriberService.findAllSubscribedEvents(subscriber.getId());
		assertEquals(1,events.size());
	}
	
	@Test
	public void subscribeForEvent(){
		subscriberService.subscribe(event.getId(), subscriber.getId(), "freu!");
		List<Event> events = subscriberService.findAllSubscribedEvents(subscriber.getId());
		assertTrue(events.contains(event));
	}
	
	@Test
	public void unsubscribeFromEvent(){
		subscriber = subscriberRepository.findOne(4L);
		List<Event> events = subscriberService.findAllSubscribedEvents(subscriber.getId());
		Event eventToUnsubscribe = events.get(0);
		subscriberService.unsubscribe(eventToUnsubscribe.getId(), subscriber.getId());
		events = subscriberService.findAllSubscribedEvents(subscriber.getId());
		assertFalse(events.contains(eventToUnsubscribe));
	}
	
	@Test
	public void findAllConfirmedEvents(){
		List<Event> events = subscriberService.findAllConfirmedEvents();
		assertEquals(events.size(), 1);	
	}
	@Test(expectedExceptions=ConstraintViolationException.class)
	public void checkNullConstraintFindAllSubscribedEvents(){
		subscriberService.findAllSubscribedEvents(null);
	}
	
	@Test
	public void checkNullConstraintsSubscribe(){
		try{
			subscriberService.subscribe(0L, null, "");
			fail();
		}catch(ConstraintViolationException e1){/*OK*/}
		
		try{
			subscriberService.subscribe(null, 0L, "");
			fail();
		}catch(ConstraintViolationException e2){/*OK*/}
	}
	
	@Test
	public void checkNullConstraintsUnsubscribe(){
		try{
			subscriberService.unsubscribe(0L, null);
			fail();
		}catch(ConstraintViolationException e1){/*OK*/}
		
		try{
			subscriberService.unsubscribe(null, null);
			fail();
		}catch(ConstraintViolationException e2){/*OK*/}
	}
}
