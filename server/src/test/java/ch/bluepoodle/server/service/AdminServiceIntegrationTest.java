package ch.bluepoodle.server.service;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Publisher;
import ch.bluepoodle.server.AbstractIntegrationTest;
import ch.bluepoodle.server.repository.EventRepository;
import ch.bluepoodle.server.repository.EventTypeRepository;
import ch.bluepoodle.server.repository.LocationRepository;
import ch.bluepoodle.server.repository.PublisherRepository;
import ch.bluepoodle.server.service.PublisherService;

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
