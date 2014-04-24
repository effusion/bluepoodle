package ch.buepoodle.frontend.springrest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ch.bluepoodle.config.TestServerApplicationConfig;

@Configuration
@ComponentScan("ch.bluepoodle.frontend.springrest.controller")
@EnableWebMvc
@Import({TestServerApplicationConfig.class,TestSecSecurityConfig.class})
public class TestWebConfig extends WebMvcConfigurerAdapter {

    public TestWebConfig() {
        super();
    }   
}
