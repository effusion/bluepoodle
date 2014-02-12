package ch.atos.tm.bluepoodle.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EventType {
	@Id
	@GeneratedValue
	private Long eventTypeId;
	private String name;
	private String description;
	@ManyToOne
	private Publisher publisher;
	@OneToMany(mappedBy = "eventType")
	private Set<Event> events;
	
	@ManyToMany
	@JoinTable(name = "eventtype_location_assoc", joinColumns = { 
			@JoinColumn(name = "eventtypeid", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "locationid", 
					nullable = false, updatable = false) })
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
	
	
}
