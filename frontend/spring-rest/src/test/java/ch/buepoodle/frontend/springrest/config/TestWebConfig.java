package ch.buepoodle.frontend.springrest.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ch.bluepoodle.service.PublisherService;

@Configuration
@ComponentScan("ch.bluepoodle.frontend.springrest.controller")
@EnableWebMvc
public class TestWebConfig extends WebMvcConfigurerAdapter {

    public TestWebConfig() {
        super();
    }
    
    @Bean
    public PublisherService publisherService(){
    	return Mockito.mock(PublisherService.class);
    }
    
}
