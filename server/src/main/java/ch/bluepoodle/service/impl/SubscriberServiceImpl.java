package ch.bluepoodle.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.bluepoodle.domain.QEvent;
import ch.bluepoodle.domain.QSubscription;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventState;
import ch.bluepoodle.domain.Subscriber;
import ch.bluepoodle.domain.Subscription;
import ch.bluepoodle.repository.EventRepository;
import ch.bluepoodle.repository.SubscriberRepository;
import ch.bluepoodle.repository.SubscriptionRepository;
import ch.bluepoodle.service.SubscriberService;

import com.mysema.query.jpa.hibernate.HibernateDeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;

@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Override
	public List<Event> findAllSubscribedEvents(Subscriber subscriber) {
		QEvent event = QEvent.event;
		QSubscription subscription = QSubscription.subscription;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(event).join(event.subscriptions,subscription)
				.where(subscription.pk.subscriber.id.eq(subscriber.getId()))
				.list(event);
	}

	@Override
	public void subscribe(Event event, Subscriber subscriber, String comment) {
		event = eventRepository.findOne(event.getId());
		subscriber = subscriberRepository.findOne(subscriber.getId());
		Subscription subscription = new Subscription();
		subscription.setEvent(event);
		subscription.setSubscriber(subscriber);
		subscription.setComment(comment);
		subscriptionRepository.save(subscription);
	}

	@Override
	public void unsubscribe(Event event, Subscriber subscriber) {
		QSubscription subscription = QSubscription.subscription;
		HibernateDeleteClause delete = new HibernateDeleteClause(em.unwrap(Session.class), subscription);
		delete.where(subscription.pk.event.eq(event)
				.and(subscription.pk.subscriber.eq(subscriber)))
				.execute();
	}

	@Override
	public List<Event> findAllConfirmedEvents() {
		QEvent event = QEvent.event;
		QSubscription subscription = QSubscription.subscription;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(event).join(event.subscriptions,subscription)
				.where(subscription.pk.event.state.eq(EventState.CONFIRMED))
				.list(event);
	}
}
