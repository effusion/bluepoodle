package ch.bluepoodle.datatransfer;

import org.joda.time.LocalDateTime;

import ch.bluepoodle.domain.EventState;


public class EventDTO extends BaseDTO {
	private static final long serialVersionUID = 4786942822061836258L;
	
	private Long eventTypeId;
	private Long locationId;
	private String name;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private EventState state;
	
	public EventDTO(){
		super();
		state = EventState.PLANNED;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public void plan(){
		state = EventState.PLANNED;
	}
	
	public void confirm(){
		state = EventState.CONFIRMED;
	}
	
	public void cancel(){
		state = EventState.CANCELLED;
	}
	
	public EventState getState(){
		return state;
	}
	
	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
}
