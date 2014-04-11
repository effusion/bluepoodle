package ch.bluepoodle.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Publisher extends Person {
	private static final long serialVersionUID = 2981198960907676793L;
	@OneToMany(mappedBy = "publisher")
	private Set<EventType> eventTypes;
	@OneToMany(mappedBy = "publisher")
	private Set<Event> events;

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<EventType> getEventTypes() {
		return eventTypes;
	}

	public void setEventTypes(Set<EventType> eventTypes) {
		this.eventTypes = eventTypes;
	}
}
