package ch.buepoodle.frontend.springrest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:applicationContext-security.xml" })
@ComponentScan("ch.bluepoodle.frontend.springrest.security")
public class TestSecSecurityConfig {

    public TestSecSecurityConfig() {
        super();
    }

}
