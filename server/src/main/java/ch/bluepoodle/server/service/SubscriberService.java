package ch.bluepoodle.server.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import ch.bluepoodle.domain.Event;

@Validated
public interface SubscriberService {
	List<Event> findAllSubscribedEvents(@NotNull Long subscriberId);
	void subscribe(@NotNull Long eventId, @NotNull Long subscriberId, String comment);
	void unsubscribe(@NotNull Long eventId, @NotNull Long subscriberId);
	List<Event> findAllConfirmedEvents();

}
