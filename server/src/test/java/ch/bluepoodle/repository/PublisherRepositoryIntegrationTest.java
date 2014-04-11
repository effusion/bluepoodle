package ch.bluepoodle.repository;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.Assert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.QPublisher;
import ch.bluepoodle.AbstractIntegrationTest;
import ch.bluepoodle.domain.Publisher;
import ch.bluepoodle.repository.PublisherRepository;

import com.mysema.query.types.expr.BooleanExpression;

@Transactional
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
		publisherRepository.delete(publisher.getId());
		Assert.assertNull(publisherRepository.findOne(publisher.getId()));
	}
	
	@Test
	public void findPublisherByLastName(){
		String lastName = "Heubeck";
		List<Publisher> publisher = publisherRepository.findByLastName(lastName);
		Assert.assertEquals(1,publisher.size());
		Assert.assertEquals(lastName, publisher.get(0).getLastName());
	}
	
	@Test
	public void findPublisherByUserName(){
		String username = "heuby";
		List<Publisher> publisher = publisherRepository.findByUserName(username);
		Assert.assertEquals(1,publisher.size());
		Assert.assertEquals(username, publisher.get(0).getUserName());
	} 
	
	@Test
	public void findPublisherByFirstName(){
		String firstName = "Pascal";
		List<Publisher> publisher = publisherRepository.findByFirstName(firstName);
		Assert.assertEquals(1,publisher.size());
		Assert.assertEquals(firstName, publisher.get(0).getFirstName());
	}
	
	@Test
	public void findPublisherByEmail(){
		String email = "andreas.kuhtz@atos.ch";
		List<Publisher> publisher = publisherRepository.findByEmail(email);
		Assert.assertEquals(1,publisher.size());
		Assert.assertEquals(email, publisher.get(0).getEmail());
	}

	@Test
	public void findPublisherByEmailQuerydsl(){
		String email = "andreas.kuhtz@atos.ch";
		QPublisher qPublisher = QPublisher.publisher;
		BooleanExpression emailName = qPublisher.email.eq(email);
		Iterable<Publisher> publishers = publisherRepository.findAll(emailName);
		List<Publisher> publisher = (List<Publisher>) publishers;
		Assert.assertEquals(1, publisher.size());
		Assert.assertEquals(email, publisher.get(0).getEmail());
	}
	
	@Test
	public void updatePublisherByName() throws Exception {
		String firstName = "publisher";
		List<Publisher> result = publisherRepository.findByFirstName(firstName);
		Publisher toUpdate = result.get(0);
		String email = "newpublisher@atos.ch";
		toUpdate.setEmail(email);
		publisherRepository.save(toUpdate);
		List<Publisher> updated = publisherRepository.findByFirstName(firstName);
		assertEquals(email, updated.get(0).getEmail());
	}
}
