package ch.bluepoodle.frontend.springrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import ch.bluepoodle.datatransfer.EventDTO;
import ch.bluepoodle.domain.Event;
import ch.bluepoodle.util.MapperUtil;
import ch.bluepoodle.server.service.SubscriberService;

@Controller
@RequestMapping(value = "/subscriber")
public class SubscriberController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private DozerBeanMapper eventMapping;

    public SubscriberController() {
        super();
    }

    @RequestMapping(value = "/findallaubscribedevents/{subscriberId}", method = RequestMethod.GET)
    @ResponseBody
    public List<EventDTO> findById(@PathVariable("subscriberId") final Long subscriberId, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
    	List<Event> events = subscriberService.findAllSubscribedEvents(subscriberId);
    	List<EventDTO> mappedEvents = MapperUtil.map(eventMapping, events, EventDTO.class);
    	return mappedEvents;
    }
}
