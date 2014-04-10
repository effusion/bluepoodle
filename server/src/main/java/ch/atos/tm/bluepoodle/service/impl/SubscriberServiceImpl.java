package ch.atos.tm.bluepoodle.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.atos.tm.bluepoodle.domain.Event;
import ch.atos.tm.bluepoodle.domain.QEvent;
import ch.atos.tm.bluepoodle.domain.QSubscription;
import ch.atos.tm.bluepoodle.domain.Subscriber;
import ch.atos.tm.bluepoodle.domain.Subscription;
import ch.atos.tm.bluepoodle.repository.EventRepository;
import ch.atos.tm.bluepoodle.repository.SubscriberRepository;
import ch.atos.tm.bluepoodle.repository.SubscriptionRepository;
import ch.atos.tm.bluepoodle.service.SubscriberService;

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
	public List<Event> findAllEvents(Subscriber subscriber) {
		QEvent event = QEvent.event;
		QSubscription subscription = QSubscription.subscription;
		JPAQuery query = new JPAQuery(em);
		List<Event> result = query.distinct().from(event).join(event.subscriptions,subscription)
				.where(subscription.pk.subscriber.id.eq(subscriber.getId()))
				.list(event);
		return result;
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
}
