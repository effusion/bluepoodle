package ch.bluepoodle.vaadin.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import ch.bluepoodle.server.config.ServerApplicationConfig;

@Configuration
@ComponentScan({ "ch.bluepoodle.vaadin.ui" })
@EnableAspectJAutoProxy
@Import({ServerApplicationConfig.class})
public class VaadinApplicationConfig {
	
	public VaadinApplicationConfig() {
		System.err.println("*************************");
	}

	@Bean
	public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator() {
		AnnotationAwareAspectJAutoProxyCreator aop = new AnnotationAwareAspectJAutoProxyCreator();
		return aop;
	}
}
