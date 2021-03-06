package ch.bluepoodle.datatransfer;

import java.util.HashSet;
import java.util.Set;

public class PublisherDTO extends PersonDTO {
	private static final long serialVersionUID = 2981198960907676793L;
	
	private Set<EventDTO> events = new HashSet<EventDTO>();

	public Set<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(Set<EventDTO> events) {
		this.events = events;
	}
	
	public void addEvent(EventDTO event){
		events.add(event);
	}
}
