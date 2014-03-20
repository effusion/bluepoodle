package ch.atos.tm.bluepoodle.repository;

import org.testng.Assert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.atos.tm.bluepoodle.AbstractIntegrationTest;
import ch.atos.tm.bluepoodle.domain.Location;

public class LocationRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	public LocationRepository locationRepository;
	
	@Test
	public void saveLocation() {
		Location location = new Location();
		location.setName("ETH Zürich");
		locationRepository.save(location);
	}
	
	@Test
	public void findLocationByName(){
		String name = "Technopark";
		List<Location> location = locationRepository.findByName(name);
		Assert.assertEquals(1,location.size());
		Assert.assertEquals(name, location.get(0).getName());
	}
}
