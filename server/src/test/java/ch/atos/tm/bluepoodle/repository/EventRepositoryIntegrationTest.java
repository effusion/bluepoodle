package ch.atos.tm.bluepoodle.repository;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.QEvent;

import com.google.common.collect.Lists;
import com.mysema.query.types.expr.BooleanExpression;

public class EventRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private EventRepository eventRepository;
	private Calendar calendar = new GregorianCalendar();
	
	@Test
	public void saveEvent() {
		Event event = new Event();
		event.setName("Jazoon");
		calendar.set(2014, Calendar.JUNE, 14);
		event.setStartDate(calendar.getTime());
		calendar.set(2014, Calendar.JUNE, 16);
		event.setEndDate(calendar.getTime());
		eventRepository.save(event);
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
		assertEquals(2, events.size());
	}
}
