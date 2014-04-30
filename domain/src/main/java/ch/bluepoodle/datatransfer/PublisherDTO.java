package ch.bluepoodle.datatransfer;

import java.util.Set;

import ch.bluepoodle.domain.Person;

public class PublisherDTO extends PersonDTO {
	private static final long serialVersionUID = 2981198960907676793L;
	
	private Set<EventDTO> events;

	public Set<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(Set<EventDTO> events) {
		this.events = events;
	}
}
