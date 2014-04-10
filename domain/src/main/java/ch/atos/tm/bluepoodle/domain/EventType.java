package ch.atos.tm.bluepoodle.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EventType extends BaseEntity{

	private static final long serialVersionUID = -2302204843643822946L;
	private String name;
	private String description;
	@ManyToOne
	private Publisher publisher;
	@OneToMany(mappedBy = "eventType")
	private Set<Event> events;

	@ManyToMany
	@JoinTable(name = "eventtype_location_assoc", 
		joinColumns = { @JoinColumn(name = "eventtype_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "location_id", nullable = false, updatable = false) })
	private Set<Location> location;

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

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

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}
}
