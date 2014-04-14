package ch.bluepoodle.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Publisher;
import ch.bluepoodle.domain.Subscriber;


public interface PublisherService {
	List<Event> findAllEvents(@NotNull Publisher publisher);
	Event update(@NotNull Event event);
	List<EventType> findAllEventTypes(@NotNull Publisher publisher);
	void deleteEvent(@NotNull Event event, @NotNull Publisher publisher);
	Event createEvent(@NotNull Event event);
	List<Subscriber> findAllSubscribers(@NotNull Event event);
	void addSubscriberToEvent(@NotNull Event event, @NotNull Subscriber subscriber, String comment);
}
