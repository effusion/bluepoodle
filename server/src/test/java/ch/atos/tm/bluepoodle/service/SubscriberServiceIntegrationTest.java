package ch.atos.tm.bluepoodle.service;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.AbstractIntegrationTest;
import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.Subscriber;
import ch.atos.tm.bluepoodle.repository.EventRepository;
import ch.atos.tm.bluepoodle.repository.SubscriberRepository;

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
		List<Event> events = subscriberService.findAllEvents(subscriber);
		assertEquals(1,events.size());
	}
	
	@Test
	public void subscribeForEvent(){
		subscriberService.subscribe(event, subscriber, "freu!");
		List<Event> events = subscriberService.findAllEvents(subscriber);
		assertTrue(events.contains(event));
	}
	
	@Test
	public void unsubscribeFromEvent(){
		subscriber = subscriberRepository.findOne(4L);
		List<Event> events = subscriberService.findAllEvents(subscriber);
		Event eventToUnsubscribe = events.get(0);
		subscriberService.unsubscribe(eventToUnsubscribe, subscriber);
		events = subscriberService.findAllEvents(subscriber);
		assertFalse(events.contains(eventToUnsubscribe));
	}
}
