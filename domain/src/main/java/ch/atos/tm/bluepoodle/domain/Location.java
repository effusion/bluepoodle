package ch.atos.tm.bluepoodle.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private Long locationId;	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "location" )
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
}
