package ch.bluepoodle.server.repository;

import org.testng.Assert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.Subscriber;
import ch.bluepoodle.server.AbstractIntegrationTest;
import ch.bluepoodle.server.repository.SubscriberRepository;

@Transactional
public class SubscriberRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Test
	public void savePublisher() {
		Subscriber subscriber = new Subscriber();
		subscriber.setEmail("hans.muster@beispiel.ch");
		subscriber.setLastName("Muster");
		subscriber.setFirstName("Hans");			
		subscriberRepository.save(subscriber);
	}
	
	@Test
	public void deletePublisher(){
		Subscriber subscriber = new Subscriber();
		subscriber.setEmail("deleteme@erase.ch");
		subscriber.setLastName("Delete");
		subscriber.setFirstName("Me");			
		subscriber = subscriberRepository.save(subscriber);
		subscriberRepository.delete(subscriber.getId());
		Assert.assertNull(subscriberRepository.findOne(subscriber.getId()));
	}
	
	@Test
	public void findPublisherByLastName(){
		String lastName = "Goebel";
		List<Subscriber> subscriber = subscriberRepository.findByLastName(lastName);
		Assert.assertEquals(1,subscriber.size());
		Assert.assertEquals(lastName, subscriber.get(0).getLastName());
	}
	
	@Test
	public void findPublisherByUserName(){
		String username = "dani";
		List<Subscriber> subscriber = subscriberRepository.findByUserName(username);
		Assert.assertEquals(1,subscriber.size());
		Assert.assertEquals(username, subscriber.get(0).getUserName());
	} 
	
	@Test
	public void findPublisherByFirstName(){
		String firstName = "Patrick";
		List<Subscriber> subscriber = subscriberRepository.findByFirstName(firstName);
		Assert.assertEquals(1,subscriber.size());
		Assert.assertEquals(firstName, subscriber.get(0).getFirstName());
	}
	
	@Test
	public void findPublisherByEmail(){
		String email = "martin.goebel@atos.ch";
		List<Subscriber> subscriber = subscriberRepository.findByEmail(email);
		Assert.assertEquals(1,subscriber.size());
		Assert.assertEquals(email, subscriber.get(0).getEmail());
	}
}
