package ch.atos.tm.bluepoodle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.atos.tm.bluepoodle.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {}
