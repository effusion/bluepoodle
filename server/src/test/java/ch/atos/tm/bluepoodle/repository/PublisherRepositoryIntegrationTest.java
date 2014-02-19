package ch.atos.tm.bluepoodle.repository;

import static org.testng.AssertJUnit.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.domain.Publisher;


public class PublisherRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Test
	public void savePublisher() {
		Publisher publisher = new Publisher();
		publisher.setEmail("hans.muster@beispiel.ch");
		publisher.setLastName("Muster");
		publisher.setFirstName("Hans");			
		publisherRepository.save(publisher);
	}
	
	@Test
	public void deletePublisher(){
		Publisher publisher = new Publisher();
		publisher.setEmail("deleteme@erase.ch");
		publisher.setLastName("Delete");
		publisher.setFirstName("Me");			
		publisher = publisherRepository.save(publisher);
		publisherRepository.delete(publisher.getPersonId());
		assertNull(publisherRepository.findOne(publisher.getPersonId()));
	}
	
	@Test
	public void findPublisherByLastName(){
		String lastName = "Heubeck";
		List<Publisher> publisher = publisherRepository.findByLastName(lastName);
		assertEquals(1,publisher.size());
		assertEquals(lastName, publisher.get(0).getLastName());
	}
	
	@Test
	public void findPublisherByUserName(){
		String username = "heuby";
		List<Publisher> publisher = publisherRepository.findByUserName(username);
		assertEquals(1,publisher.size());
		assertEquals(username, publisher.get(0).getUserName());
	} 
	
	@Test
	public void findPublisherByFirstName(){
		String firstName = "Pascal";
		List<Publisher> publisher = publisherRepository.findByFirstName(firstName);
		assertEquals(1,publisher.size());
		assertEquals(firstName, publisher.get(0).getFirstName());
	}
	
	@Test
	public void findPublisherByEmail(){
		String email = "andreas.kuhtz@atos.ch";
		List<Publisher> publisher = publisherRepository.findByEmail(email);
		assertEquals(1,publisher.size());
		assertEquals(email, publisher.get(0).getEmail());
	}
}
