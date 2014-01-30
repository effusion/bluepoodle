package ch.atos.tm.bluepoodle.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SubscriptionCompositePK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2946794011624729478L;
	
	
	@ManyToOne()
	@JoinColumn(name = "eventid")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "subscriberid")
	private Subscriber subscriber;
	
	

	public SubscriptionCompositePK(Event event, Subscriber subscriber) {
		super();
		this.event = event;
		this.subscriber = subscriber;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	
	
}
