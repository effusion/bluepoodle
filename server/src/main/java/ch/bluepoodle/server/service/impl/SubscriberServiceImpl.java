package ch.bluepoodle.server.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventState;
import ch.bluepoodle.domain.QEvent;
import ch.bluepoodle.domain.QSubscription;
import ch.bluepoodle.domain.Subscription;
import ch.bluepoodle.server.repository.EventRepository;
import ch.bluepoodle.server.repository.SubscriberRepository;
import ch.bluepoodle.server.repository.SubscriptionRepository;
import ch.bluepoodle.server.service.SubscriberService;

import com.mysema.query.jpa.hibernate.HibernateDeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;

@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {
	
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Override
	public List<Event> findAllSubscribedEvents(Long subscriberId) {
		QEvent event = QEvent.event;
		QSubscription subscription = QSubscription.subscription;
		JPAQuery query = new JPAQuery(em);
		return query.distinct().from(event).join(event.subscriptions,subscription)
				.where(subscription.pk.subscriber.id.eq(subscriberId))
				.list(event);
	}

	@Override
	public void subscribe(Long eventId, Long subscriberId, String comment) {
		Subscription subscription = new Subscription();
		subscription.setEvent(eventRepository.findOne(eventId));
		subscription.setSubscriber(subscriberRepository.findOne(subscriberId));
		subscription.setComment(comment);
		subscriptionRepository.save(subscription);
	}

	@Override
	public void unsubscribe(Long eventId, Long subscriberId) {
		QSubscription subscription = QSubscription.subscription;
		HibernateDeleteClause delete = new HibernateDeleteClause(em.unwrap(Session.class), subscription);
		delete.where(subscription.pk.event.id.eq(eventId)
				.and(subscription.pk.subscriber.id.eq(subscriberId)))
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
