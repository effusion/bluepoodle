package ch.bluepoodle.datatransfer;

import static org.testng.Assert.*;

import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Location;
import ch.bluepoodle.domain.Publisher;


public class PublisherMappingTest {
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@BeforeClass
	public void setUp(){
		mapper.addMapping(new PublisherMapping());
		mapper.addMapping(new EventMapping());
	}
	
	@Test
	public void mappingTest(){
		EventType eventType = new EventType();
		eventType.setId(2L);
		eventType.setName("Developer Conference");
		Location location = new Location();
		location.setId(2L);
		Event event = new Event();
		event.setId(2L);
		String eventName = "JavaOne";
		event.setName(eventName);
		event.setLocation(location);
		event.setEventType(eventType);
		Publisher publisher = new Publisher();
		publisher.setId(1L);
		publisher.addEvent(event);
		String firstName = "Andreas";
		publisher.setFirstName(firstName);
		String lastName = "Heubeck";
		publisher.setLastName(lastName);
		PublisherDTO dto = mapper.map(publisher, PublisherDTO.class);
		assertEquals(publisher.getId(),dto.getId());
		assertEquals(publisher.getFirstName(),dto.getFirstName());
		assertEquals(publisher.getLastName(),dto.getLastName());
		assertNotNull(publisher.getEvents());
		Set<EventDTO> events = dto.getEvents();
		EventDTO eventdto = new EventDTO();
		for (EventDTO eventDTO : events) {
			eventdto = eventDTO;
			break;
		}
		assertEquals(eventdto.getName(), eventName);
		assertNotNull(eventdto.getLocationId());
		assertNotNull(eventdto.getEventTypeId());
		
		
	}
}
