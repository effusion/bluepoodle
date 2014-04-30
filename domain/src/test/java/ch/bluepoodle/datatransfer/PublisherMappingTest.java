package ch.bluepoodle.datatransfer;

import static org.testng.Assert.assertEquals;

import org.dozer.DozerBeanMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.Publisher;


public class PublisherMappingTest {
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@BeforeClass
	public void setUp(){
		mapper.addMapping(new PublisherMapping());
	}
	
	@Test
	public void mappingTest(){
		Publisher publisher = new Publisher();
		publisher.setId(1L);
		PublisherDTO dto = mapper.map(publisher, PublisherDTO.class);
		assertEquals(publisher.getId(),dto.getId());
		
	}
}
