package ch.atos.tm.bluepoodle.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.EventType;
import ch.atos.tm.bluepoodle.domain.Publisher;
import ch.atos.tm.bluepoodle.domain.QEvent;
import ch.atos.tm.bluepoodle.domain.QEventType;
import ch.atos.tm.bluepoodle.repository.EventRepository;
import ch.atos.tm.bluepoodle.repository.EventTypeRepository;
import ch.atos.tm.bluepoodle.service.PublisherService;

import com.mysema.query.types.expr.BooleanExpression;
import com.google.common.collect.Lists;
@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Override
	public List<Event> findAllEvents(Publisher publisher) {
		QEvent qevent = QEvent.event;
		BooleanExpression query = qevent.publisher.eq(publisher);
		return Lists.newArrayList(eventRepository.findAll(query));
	}

	@Override
	public void save(Event event) {
		eventRepository.save(event);
	}

	@Override
	public List<EventType> findAllEventTypes(Publisher publisher) {
		QEventType qeventType = QEventType.eventType;
		BooleanExpression query  = qeventType.publisher.eq(publisher);
		return Lists.newArrayList(eventTypeRepository.findAll(query));
	}

	@Override
	public void deleteEvent(Event event) {
		eventRepository.delete(event);		
	}
}
