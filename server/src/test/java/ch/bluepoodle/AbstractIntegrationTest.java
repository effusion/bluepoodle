package ch.bluepoodle;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import ch.bluepoodle.config.TestApplicationConfig;

@ContextConfiguration(classes={TestApplicationConfig.class})
public abstract class AbstractIntegrationTest extends AbstractTestNGSpringContextTests{}
