package ch.atos.tm.bluepoodle.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Subscriber extends Person {

	@OneToMany(mappedBy = "pk.subscriber")
	private Set<Subscription> subscriptions;

	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
}
