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
	public void findPublisherByLastName(){
		List<Publisher> publishers = publisherRepository.findPublisherByLastName("Heubeck");
		assertEquals(1,publishers.size());
	} 
}
