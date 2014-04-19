package ch.bluepoodle.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.Subscriber;

@Validated
public interface SubscriberService {
	List<Event> findAllSubscribedEvents(@NotNull Subscriber subscriber);
	void subscribe(@NotNull Event event, @NotNull Subscriber subscriber, String comment);
	void unsubscribe(@NotNull Event event, @NotNull Subscriber subscriber);
	List<Event> findAllConfirmedEvents();

}
