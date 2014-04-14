package ch.bluepoodle.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.Subscriber;

public interface SubscriberService {
	List<Event> findAllSubscribedEvents(@NotNull Subscriber subscriber);
	void subscribe(@NotNull Event event, @NotNull Subscriber subscriber, String comment);
	void unsubscribe(@NotNull Event event, @NotNull Subscriber subscriber);
	List<Event> findAllConfirmedEvents();

}
