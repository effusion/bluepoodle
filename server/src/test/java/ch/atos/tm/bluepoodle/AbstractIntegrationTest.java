package ch.atos.tm.bluepoodle;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations={"classpath:application-context-test.xml"})
@Transactional
public abstract class AbstractIntegrationTest extends AbstractTestNGSpringContextTests{}
