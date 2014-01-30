package ch.atos.tm.bluepoodle.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Subscription {
	
	@EmbeddedId
	private SubscriptionCompositePK pk;
	
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Event getEvent() {
		return pk.getEvent();
	}

	public void setEvent(Event event) {
		this.pk.setEvent(event);
	}

	public Subscriber getSubscriber() {
		return pk.getSubscriber();
	}

	public void setSubscriber(Subscriber subscriber) {
		this.pk.setSubscriber(subscriber);
	}	
}
