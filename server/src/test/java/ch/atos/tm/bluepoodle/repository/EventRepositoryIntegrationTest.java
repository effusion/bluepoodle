package ch.atos.tm.bluepoodle.repository;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.AbstractIntegrationTest;
import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.QEvent;

import com.google.common.collect.Lists;
import com.mysema.query.types.expr.BooleanExpression;

@Transactional
public class EventRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Test
	public void saveEvent() {
		Event event = new Event();
		event.setName("Jazoon");
		event.setStartDate(new LocalDateTime(2014,7,4,8,0));
		event.setEndDate(new LocalDateTime(2014,7,5,17,0));
		eventRepository.save(event);
	}
	
	@Test
	public void findEventByName(){
		String name = "W-JAX";
		List<Event> event = eventRepository.findByName(name);
		Assert.assertEquals(1,event.size());
		Assert.assertEquals(name, event.get(0).getName());
	}
	
	@Test
	public void findEventByType(){
		QEvent qEvent = QEvent.event;
		BooleanExpression isEventType = qEvent.eventType.name.eq("Entwicklerkonferenz");
		Iterable<Event> result = eventRepository.findAll(isEventType);
		List<Event> events = Lists.newArrayList(result);
		Assert.assertEquals(3, events.size());
	}
}
