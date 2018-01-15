package uk.gov.digital.ho.egar.flyway.support.impl;

import org.flywaydb.core.Flyway;
import uk.gov.digital.ho.egar.flyway.FlywayRunnerArgs;
import uk.gov.digital.ho.egar.flyway.support.FlywaySupport;

import javax.sql.DataSource;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresFlywaySupport implements FlywaySupport {

	private DataSource datasource;

	private URI jdbcUri;

	private FlywayRunnerArgs flywayRunnerArgs ;

	public PostgresFlywaySupport(DataSource datasource, URI jdbcUri, FlywayRunnerArgs flywayRunnerArgs) {
		this.datasource = datasource;
		this.jdbcUri = jdbcUri;
		this.flywayRunnerArgs = flywayRunnerArgs;
	}

	public void createDatabaseIfRequired() throws SQLException {
		try {
			datasource.getConnection();
		} catch (SQLException e) {


			String defaultUrl = String.format("jdbc:%s://%s%s/postgres", jdbcUri.getScheme(), jdbcUri.getHost(), (jdbcUri.getPort() != -1 ? ":" + jdbcUri.getPort() : ""));
			//Only retrieve the db name
			String originalDb = jdbcUri.getPath().split(";")[0];
			//Removes "/" prefix
			originalDb = originalDb.startsWith("/") ? originalDb.substring(1) : originalDb;

			if (!flywayRunnerArgs.areAdminCredentialsSet()){
				throw new UnsupportedOperationException("Admin db credentials not specified. Unable to create DB.");
			}

			Connection conn = DriverManager.getConnection(defaultUrl, flywayRunnerArgs.getAdminUsername(), flywayRunnerArgs.getAdminPassword());
			Statement stmt = conn.createStatement();
			stmt.execute("CREATE DATABASE " + originalDb);
			conn.close();
		}
	}

	@Override
	public void executeFlyway() {
		String[] arguments = flywayRunnerArgs.getFlywayProperties();
		Flyway flyway = createFlyway();
		for(String argument:arguments){
			switch (argument){
				case "migrate" :
					flyway.migrate();
					break;
				case "clean"   :
					flyway.clean();
					break;
				case "info"    :
					flyway.info();
					break;
				case "validate":
					flyway.validate();
					break;
				case "baseline":
					flyway.baseline();
					break;
				case "repair"  :
					flyway.repair();
					break;
				default:
					throw new IllegalArgumentException("Expecting one of the following arguments: migrate, clean, info ,validate, baseline or repair.");
			}
		}
	}

	private Flyway createFlyway(){
		Flyway flyway  = new Flyway();
		flyway.setDataSource(datasource);
		flyway.setBaselineOnMigrate(flywayRunnerArgs.getBaselineOnMigrate());
		flyway.setSchemas(flywayRunnerArgs.getSchemas());
		return flyway;
	}
}
