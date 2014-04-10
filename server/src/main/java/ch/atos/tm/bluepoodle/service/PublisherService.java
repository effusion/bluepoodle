package ch.atos.tm.bluepoodle.service;

import java.util.List;

import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.EventType;
import ch.atos.tm.bluepoodle.domain.Publisher;


public interface PublisherService {
	List<Event> findAllEvents(Publisher publisher);
	Event update(Event event);
	List<EventType> findAllEventTypes(Publisher publisher);
	void deleteEvent(Event event, Publisher publisher);
	Event createEvent(Event event);
}
