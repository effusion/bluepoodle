package ch.bluepoodle.service;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ch.bluepoodle.AbstractIntegrationTest;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.Subscriber;
import ch.bluepoodle.repository.EventRepository;
import ch.bluepoodle.repository.SubscriberRepository;
import ch.bluepoodle.service.SubscriberService;

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
		List<Event> events = subscriberService.findAllSubscribedEvents(subscriber);
		assertEquals(1,events.size());
	}
	
	@Test
	public void subscribeForEvent(){
		subscriberService.subscribe(event, subscriber, "freu!");
		List<Event> events = subscriberService.findAllSubscribedEvents(subscriber);
		assertTrue(events.contains(event));
	}
	
	@Test
	public void unsubscribeFromEvent(){
		subscriber = subscriberRepository.findOne(4L);
		List<Event> events = subscriberService.findAllSubscribedEvents(subscriber);
		Event eventToUnsubscribe = events.get(0);
		subscriberService.unsubscribe(eventToUnsubscribe, subscriber);
		events = subscriberService.findAllSubscribedEvents(subscriber);
		assertFalse(events.contains(eventToUnsubscribe));
	}
	
	@Test
	public void findAllConfirmedEvents(){
		List<Event> events = subscriberService.findAllConfirmedEvents();
		assertEquals(events.size(), 1);
		
	}
}