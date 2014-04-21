package ch.bluepoodle;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import ch.bluepoodle.config.ServerApplicationConfig;

@ContextConfiguration(classes={ServerApplicationConfig.class})
public abstract class AbstractIntegrationTest extends AbstractTestNGSpringContextTests{}
