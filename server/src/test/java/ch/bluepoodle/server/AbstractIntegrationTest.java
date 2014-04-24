package ch.bluepoodle.server;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import ch.bluepoodle.server.config.ServerApplicationConfig;

@ContextConfiguration(classes={ServerApplicationConfig.class})
public abstract class AbstractIntegrationTest extends AbstractTestNGSpringContextTests{}
