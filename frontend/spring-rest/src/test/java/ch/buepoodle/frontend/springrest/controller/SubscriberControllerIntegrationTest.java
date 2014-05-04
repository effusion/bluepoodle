package ch.buepoodle.frontend.springrest.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.testng.annotations.Test;

import ch.bluepoodle.server.service.SubscriberService;
import ch.buepoodle.frontend.springrest.AbstractIntegrationTest;

public class SubscriberControllerIntegrationTest extends AbstractIntegrationTest {
	
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";
	
	@Autowired
	private SubscriberService subscriberService;
    
    @Autowired
    private MockServletContext mockServletContext;
    
    @Test
    public void findAllEvents() throws Exception {
    	mockMvc.perform(get("/subscriber/findallaubscribedevents/8")
    			.accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
    			.andExpect(status().isOk())
    			.andExpect(content().contentType(APPLICATION_JSON_CHARSET_UTF_8))
    			.andExpect(jsonPath("$[0].id", is(16)))
    			.andExpect(jsonPath("$[0].name", is("JavaOne")));
    }

}
