package ch.bluepoodle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.bluepoodle.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {}
