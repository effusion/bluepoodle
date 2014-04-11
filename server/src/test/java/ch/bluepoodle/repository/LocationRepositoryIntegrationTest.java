package ch.bluepoodle.repository;

import org.testng.Assert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import ch.bluepoodle.AbstractIntegrationTest;
import ch.bluepoodle.domain.Location;
import ch.bluepoodle.repository.LocationRepository;

@Transactional
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
