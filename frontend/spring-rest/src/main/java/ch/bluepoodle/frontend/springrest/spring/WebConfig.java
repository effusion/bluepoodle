package ch.bluepoodle.frontend.springrest.spring;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ch.bluepoodle.datatransfer.EventMapping;
import ch.bluepoodle.server.config.ServerApplicationConfig;

@Configuration
@ComponentScan("ch.bluepoodle.frontend.springrest.controller")
@EnableWebMvc
@Import(ServerApplicationConfig.class)
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig() {
        super();
    }

    @Bean
    public DozerBeanMapper eventMapping(){
    	DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping(new EventMapping());
    	return mapper;
    }

}
