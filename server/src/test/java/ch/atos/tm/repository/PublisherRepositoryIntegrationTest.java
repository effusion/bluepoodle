package ch.atos.tm.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.domain.Publisher;
import ch.atos.tm.bluepoodle.repository.PublisherRepository;

@ContextConfiguration(locations={"classpath:META-INF/application-context.xml"})
@Transactional
public class PublisherRepositoryIntegrationTest extends
		AbstractTestNGSpringContextTests {
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Test
	public void savePublisher() {
		Publisher publisher = new Publisher();
		publisher.setEmail("andreas.heubeck@atos.ch");
		publisher.setLastName("Heubeck");
		publisher.setFirstName("Andreas");
		
		publisherRepository.save(publisher);
		
	}
}
