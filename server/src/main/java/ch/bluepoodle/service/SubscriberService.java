package ch.bluepoodle.service;

import java.util.List;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.Subscriber;

public interface SubscriberService {
	List<Event> findAllSubscribedEvents(Subscriber subscriber);
	void subscribe(Event event, Subscriber subscriber, String comment);
	void unsubscribe(Event event, Subscriber subscriber);
	List<Event> findAllConfirmedEvents();

}
