package ch.atos.tm.bluepoodle.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BluePoodleServer {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	}
}
