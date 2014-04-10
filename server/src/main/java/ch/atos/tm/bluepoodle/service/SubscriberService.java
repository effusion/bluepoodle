package ch.atos.tm.bluepoodle.service;

import java.util.List;

import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.Subscriber;

public interface SubscriberService {
	List<Event> findAllEvents(Subscriber subscriber);
	void subscribe(Event event, Subscriber subscriber, String comment);
	void unsubscribe(Event event, Subscriber subscriber);

}
