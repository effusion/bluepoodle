package ch.buepoodle.frontend.springrest.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

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
    	
    	mockMvc.perform(get("/publisher/findallevents/1")
    			.accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
    			.andExpect(status().isOk())
    			.andExpect(content().contentType(APPLICATION_JSON_CHARSET_UTF_8))
    			.andExpect(jsonPath("$[0].id", is(1)))
    			.andExpect(jsonPath("$[0].name", is(eventName)));
    }
    @Test
    public void createEvent() throws Exception {
    	Event event = new Event();
    	String eventName = "JavaLand";
		event.setName(eventName);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(event);
   
    	when(publisherServiceMock.createEvent(event)).thenReturn(event);
    	
    	mockMvc.perform(put("/publisher/createevent/")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(json))
    			.andExpect(status().isOk());
    }
}
