package uk.gov.digital.ho.egar.flyway.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.digital.ho.egar.flyway.FlywayRunnerArgs;
import uk.gov.digital.ho.egar.flyway.support.FlywaySupport;
import uk.gov.digital.ho.egar.flyway.support.FlywaySupportFactory;

import javax.sql.DataSource;
import java.net.URI;

@Component
public class FlywaySupportFactoryImpl implements FlywaySupportFactory {

	public static final String POSTGRESQL = "postgresql";

	@Autowired
	private FlywayRunnerArgs flywayRunnerArgs ;

	public FlywaySupport createFlywaySupport(final DataSource datasource){
		URI uri = jdbcUriFromDatasource(datasource);
		if (uri.getScheme().equalsIgnoreCase(POSTGRESQL)){
			return new PostgresFlywaySupport(datasource, uri, flywayRunnerArgs);
		}else {
			throw new UnsupportedOperationException("Database type not supported, connection to " + uri );
		}
	}

	private URI jdbcUriFromDatasource(final DataSource datasource){
		if (datasource instanceof org.apache.tomcat.jdbc.pool.DataSource) {
			org.apache.tomcat.jdbc.pool.DataSource tomcatDs = (org.apache.tomcat.jdbc.pool.DataSource) datasource;
			//removes "jdbc:" from the front of the string
			String jdbcUrl = tomcatDs.getUrl().substring(5);
			return URI.create(jdbcUrl);
		}else{
			throw new UnsupportedOperationException("Server type not supported");
		}
	}
}
