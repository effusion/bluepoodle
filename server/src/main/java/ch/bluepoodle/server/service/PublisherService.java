package ch.bluepoodle.server.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Subscriber;

@Validated
public interface PublisherService {
	List<Event> findAllEvents(@NotNull Long publisherId);
	Event updateEvent(@NotNull Event event);
	List<EventType> findAllEventTypes(@NotNull Long publisherId);
	void deleteEvent(@NotNull Long eventId, @NotNull Long publisherId);
	Event createEvent(@NotNull Event event);
	List<Subscriber> findAllSubscribers(@NotNull Long eventId);
	void addSubscriberToEvent(@NotNull Long eventId, @NotNull Long subscriberId, String comment);
}
