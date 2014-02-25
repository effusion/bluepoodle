package ch.atos.tm.bluepoodle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.Publisher;
import ch.atos.tm.bluepoodle.domain.QEvent;
import ch.atos.tm.bluepoodle.repository.EventRepository;
import ch.atos.tm.bluepoodle.service.PublisherService;
import com.mysema.query.types.expr.BooleanExpression;
import com.google.common.collect.Lists;
@Service
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> findAllEvents(Publisher publisher) {
		QEvent qevent = QEvent.event;
		BooleanExpression query = qevent.publisher.eq(publisher);
		return Lists.newArrayList(eventRepository.findAll(query));
	}

}
