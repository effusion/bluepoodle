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
		publisherRepository.delete(3L);
		assertNull(publisherRepository.findOne(3l));
	}
	
	@Test
	public void findPublisherByLastName(){
		List<Publisher> publisher = publisherRepository.findPublisherByLastName("Heubeck");
		assertEquals(1,publisher.size());
	} 
	
	@Test
	public void findPublisherByFirstName(){
		List<Publisher> publisher = publisherRepository.findPublisherByFirstName("Pascal");
		assertEquals(1,publisher.size());
	}
	
	@Test
	public void findPublisherByEmail(){
		List<Publisher> publisher = publisherRepository.findPublisherByEmail("andreas.heubeck@atos.ch");
		assertEquals(1,publisher.size());
	}
}
