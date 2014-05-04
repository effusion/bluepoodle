package ch.buepoodle.frontend.springrest.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ch.bluepoodle.config.TestServerApplicationConfig;
import ch.bluepoodle.datatransfer.EventMapping;

@Configuration
@ComponentScan("ch.bluepoodle.frontend.springrest.controller")
@EnableWebMvc
@Import({TestServerApplicationConfig.class,TestSecSecurityConfig.class})
public class TestWebConfig extends WebMvcConfigurerAdapter {

    public TestWebConfig() {
        super();
    }
    
    @Bean
    public DozerBeanMapper eventMapping(){
    	DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping(new EventMapping());
    	return mapper;
    }
}
