package ch.atos.tm.bluepoodle.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import com.mysema.query.jpa.impl.JPAQuery;
@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {
	
	@PersistenceContext
	private EntityManager em;	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Override
	public List<Event> findAllEvents(Publisher publisher) {
		QEvent event = QEvent.event;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(event).where(event.publisher.eq(publisher)).list(event);
	}

	@Override
	public Event update(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<EventType> findAllEventTypes(Publisher publisher) {
		QEventType eventType = QEventType.eventType;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(eventType).where(eventType.publisher.eq(publisher)).list(eventType);
	}

	@Override
	public void deleteEvent(Event event, Publisher publisher) {
		if(event.getPublisher().equals(publisher)){
			eventRepository.delete(event.getId());
		}
	}

	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}
}
