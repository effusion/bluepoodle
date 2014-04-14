package ch.bluepoodle.repository;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import ch.bluepoodle.AbstractIntegrationTest;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.QEvent;

import com.google.common.collect.Lists;
import com.mysema.query.types.expr.BooleanExpression;

@Transactional
public class EventRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Test
	public void saveEvent() {
		Event event = new Event();
		String name = "Jax";
		event.setName(name);
		event.setStartDate(new LocalDateTime(2014,7,4,8,0));
		event.setEndDate(new LocalDateTime(2014,7,5,17,0));
		event.setLocation(locationRepository.findOne(3L));
		event.setEventType(eventTypeRepository.findOne(1L));
		event = eventRepository.save(event);
		assertEquals(event.getName(),name);
	}
	
	@Test
	public void findEventByName(){
		String name = "W-JAX";
		List<Event> event = eventRepository.findByName(name);
		assertEquals(1,event.size());
		assertEquals(name, event.get(0).getName());
	}
	
	@Test
	public void findEventByType(){
		QEvent qEvent = QEvent.event;
		BooleanExpression isEventType = qEvent.eventType.name.eq("Entwicklerkonferenz");
		Iterable<Event> result = eventRepository.findAll(isEventType);
		List<Event> events = Lists.newArrayList(result);
		assertEquals(events.size(),3);
	}
}
