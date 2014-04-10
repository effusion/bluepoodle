package ch.atos.tm.bluepoodle.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Location extends BaseEntity{
	private static final long serialVersionUID = -7146866392356971625L;
	private String name;
	private String description;

	@OneToMany(mappedBy = "location")
	private Set<Event> event;

	@ManyToMany(mappedBy = "location")
	private Set<EventType> eventType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Event> getEvent() {
		return event;
	}

	public void setEvent(Set<Event> event) {
		this.event = event;
	}

	public Set<EventType> getEventType() {
		return eventType;
	}

	public void setEventType(Set<EventType> eventType) {
		this.eventType = eventType;
	}
}
