package ch.bluepoodle.service;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.bluepoodle.AbstractIntegrationTest;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Publisher;
import ch.bluepoodle.repository.EventRepository;
import ch.bluepoodle.repository.EventTypeRepository;
import ch.bluepoodle.repository.LocationRepository;
import ch.bluepoodle.repository.PublisherRepository;
import ch.bluepoodle.service.PublisherService;

public class AdminServiceIntegrationTest extends AbstractIntegrationTest {
	
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private EventTypeRepository eventTypeRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private EventRepository eventRepository;
	private Publisher publisher;
	
	
}
