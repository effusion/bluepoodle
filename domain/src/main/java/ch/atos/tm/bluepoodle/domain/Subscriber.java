package ch.atos.tm.bluepoodle.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Subscriber extends Person {
	private static final long serialVersionUID = -6593180429132522052L;
	@OneToMany(mappedBy = "pk.subscriber")
	private Set<Subscription> subscriptions;

	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	public void addSubscription(Subscription subscription){
		subscriptions.add(subscription);
	}
	
	public void removeSubscription(Subscription subscription){
		subscriptions.remove(subscription);
	}
}
