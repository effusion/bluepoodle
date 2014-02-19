package ch.atos.tm.bluepoodle.repository;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.domain.Subscriber;


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
		subscriberRepository.delete(subscriber.getPersonId());
		assertNull(subscriberRepository.findOne(subscriber.getPersonId()));
	}
	
	@Test
	public void findPublisherByLastName(){
		String lastName = "Goebel";
		List<Subscriber> subscriber = subscriberRepository.findByLastName(lastName);
		assertEquals(1,subscriber.size());
		assertEquals(lastName, subscriber.get(0).getLastName());
	}
	
	@Test
	public void findPublisherByUserName(){
		String username = "dani";
		List<Subscriber> subscriber = subscriberRepository.findByUserName(username);
		assertEquals(1,subscriber.size());
		assertEquals(username, subscriber.get(0).getUserName());
	} 
	
	@Test
	public void findPublisherByFirstName(){
		String firstName = "Patrick";
		List<Subscriber> subscriber = subscriberRepository.findByFirstName(firstName);
		assertEquals(1,subscriber.size());
		assertEquals(firstName, subscriber.get(0).getFirstName());
	}
	
	@Test
	public void findPublisherByEmail(){
		String email = "martin.goebel@atos.ch";
		List<Subscriber> subscriber = subscriberRepository.findByEmail(email);
		assertEquals(1,subscriber.size());
		assertEquals(email, subscriber.get(0).getEmail());
	}
}
