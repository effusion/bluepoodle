package ch.bluepoodle.service;

import java.util.List;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Publisher;


public interface PublisherService {
	List<Event> findAllEvents(Publisher publisher);
	Event update(Event event);
	List<EventType> findAllEventTypes(Publisher publisher);
	void deleteEvent(Event event, Publisher publisher);
	Event createEvent(Event event);
}
