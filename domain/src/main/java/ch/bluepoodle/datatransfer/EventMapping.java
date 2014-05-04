package ch.bluepoodle.datatransfer;

import org.dozer.loader.api.BeanMappingBuilder;

import ch.bluepoodle.domain.Event;

public class EventMapping extends BeanMappingBuilder {

	@Override
	protected void configure() {
		mapping(Event.class, EventDTO.class)
		.fields("location.id", "locationId")
		.fields("eventType.id", "eventTypeId");
	}

}
