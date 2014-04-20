package ch.bluepoodle.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.QEvent;
import ch.bluepoodle.domain.QEventType;
import ch.bluepoodle.domain.QSubscriber;
import ch.bluepoodle.domain.QSubscription;
import ch.bluepoodle.domain.Subscriber;
import ch.bluepoodle.domain.Subscription;
import ch.bluepoodle.repository.EventRepository;
import ch.bluepoodle.repository.SubscriberRepository;
import ch.bluepoodle.repository.SubscriptionRepository;
import ch.bluepoodle.service.PublisherService;

import com.mysema.query.jpa.impl.JPAQuery;
@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {
	
	@PersistenceContext
	private EntityManager em;	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Override
	public List<Event> findAllEvents(Long publisherId) {
		QEvent event = QEvent.event;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(event).
				where(event.publisher.id.eq(publisherId)).
				list(event);
	}

	@Override
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<EventType> findAllEventTypes(Long publisherId) {
		QEventType eventType = QEventType.eventType;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(eventType).
				where(eventType.publisher.id.eq(publisherId)).
				list(eventType);
	}

	@Override
	public void deleteEvent(Long eventId, Long publisherId) {
		Event event = eventRepository.findOne(eventId);
		if(event.getPublisher().getId().equals(publisherId)){
			eventRepository.delete(eventId);
		}
	}

	@Override
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Subscriber> findAllSubscribers(Long eventId) {
		QSubscriber subscriber = QSubscriber.subscriber;
		QSubscription subscription = QSubscription.subscription;
		QEvent event1 = QEvent.event;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(subscriber)
				.join(subscriber.subscriptions,subscription)
				.leftJoin(subscription.pk.event,event1)
				.where(event1.id.eq(eventId)).list(subscriber);
	}

	@Override
	public void addSubscriberToEvent(Long eventId, Long subscriberId, String comment) {
		Subscription subscription = new Subscription();
		subscription.setEvent(eventRepository.findOne(eventId));
		subscription.setSubscriber(subscriberRepository.findOne(subscriberId));
		subscription.setComment(comment);
		subscriptionRepository.save(subscription);
	}
}
