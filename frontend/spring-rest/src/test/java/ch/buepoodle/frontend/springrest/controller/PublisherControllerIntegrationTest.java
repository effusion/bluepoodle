package ch.buepoodle.frontend.springrest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.Test;

import ch.bluepoodle.domain.Event;
import ch.bluepoodle.service.PublisherService;
import ch.buepoodle.frontend.springrest.AbstractIntegrationTest;

public class PublisherControllerIntegrationTest extends AbstractIntegrationTest {
	
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";
	
	@Autowired
	private PublisherService publisherServiceMock;
    
    @Autowired
    private MockServletContext mockServletContext;

    @Test
    public void findAllEvents() throws Exception {
    	Event event = new Event();
    	event.setId(1L);
    	String eventName = "JavaOne";
		event.setName(eventName);
    	List<Event> found = new ArrayList<Event>();
    	found.add(event);
    	when(publisherServiceMock.findAllEvents(1L)).thenReturn(found);
    	
    	MvcResult result = mockMvc.perform(get("/publisher/findallevents/1").accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON_CHARSET_UTF_8))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].name", is(eventName)))
        .andReturn();
    	System.err.println(result.getResponse().getContentAsString());
        
    }
}
