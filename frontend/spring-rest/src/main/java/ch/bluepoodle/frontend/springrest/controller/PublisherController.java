package ch.bluepoodle.frontend.springrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import ch.bluepoodle.datatransfer.EventDTO;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.util.MapperUtil;
import ch.bluepoodle.server.service.PublisherService;

@Controller
@RequestMapping(value = "/publisher")
public class PublisherController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private DozerBeanMapper eventMapping;

    public PublisherController() {
        super();
    }

    @RequestMapping(value = "/findallevents/{publisherId}", method = RequestMethod.GET)
    @ResponseBody
    public List<EventDTO> findById(@PathVariable("publisherId") final Long publisherId, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
    	List<Event> events = publisherService.findAllEvents(publisherId);
    	List<EventDTO> mappedEvents = MapperUtil.map(eventMapping, events, EventDTO.class);
    	return mappedEvents;
    }
    
    @RequestMapping(value = "/createevent/", method = RequestMethod.PUT)
    @ResponseBody
    public Event createEvent(@RequestBody Event event, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
    	Event generateEvent = publisherService.createEvent(event);
    	return generateEvent;
    }
}
