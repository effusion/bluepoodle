package ch.buepoodle.frontend.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

import ch.buepoodle.frontend.springrest.config.TestSecSecurityConfig;
import ch.buepoodle.frontend.springrest.config.TestWebConfig;

@ContextConfiguration(classes={TestWebConfig.class,TestSecSecurityConfig.class})
@WebAppConfiguration
public abstract class AbstractIntegrationTest extends AbstractTestNGSpringContextTests{
	@Autowired
	protected WebApplicationContext wac;
	
	protected MockMvc mockMvc;
	
	@BeforeClass
	public void setup() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
}
