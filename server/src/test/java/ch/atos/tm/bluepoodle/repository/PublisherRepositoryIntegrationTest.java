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
		List<Publisher> publisher = publisherRepository.findPublisherByLastName("Heubeck");
		assertEquals(1,publisher.size());
	}
	
	@Test
	public void findPublisherByUserName(){
		List<Publisher> publisher = publisherRepository.findPublisherByUserName("heuby");
		assertEquals(1,publisher.size());
	} 
	
	@Test
	public void findPublisherByFirstName(){
		List<Publisher> publisher = publisherRepository.findPublisherByFirstName("Pascal");
		assertEquals(1,publisher.size());
	}
	
	@Test
	public void findPublisherByEmail(){
		List<Publisher> publisher = publisherRepository.findPublisherByEmail("andreas.kuhtz@atos.ch");
		assertEquals(1,publisher.size());
	}
}
