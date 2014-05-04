package ch.bluepoodle.vaadin.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;

public class VaadinWebAppInitializer implements  WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VaadinApplicationConfig.class);
	}
}
