package ch.atos.tm.bluepoodle.repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(locations={"classpath:application-context-test.xml"})
@Transactional
public abstract class AbstractIntegrationTest extends AbstractTestNGSpringContextTests{

	@Autowired
	DataSource dataSource;

	/**
	 * Populates the configured {@link DataSource} with data from {@code data.sql}.
	 * 
	 * @throws SQLException
	 */
	@BeforeClass
	public void populateDatabase() throws SQLException {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("data.sql"));
		executePopulator(populator);
	}

	private void executePopulator(ResourceDatabasePopulator populator)
			throws SQLException {
		Connection connection = null;
		try {
			connection = DataSourceUtils.getConnection(dataSource);
			populator.populate(connection);
		} finally {
			if (connection != null) {
				DataSourceUtils.releaseConnection(connection, dataSource);
			}
		}
	}
	@AfterClass
	public void deleteTables() throws SQLException{
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setContinueOnError(false);
		populator.setIgnoreFailedDrops(false);
		populator.addScript(new ClassPathResource("droptables.sql"));
		executePopulator(populator);
	}
}
