package uk.gov.digital.ho.egar.flyway.support.impl;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.gov.digital.ho.egar.flyway.FlywayRunnerArgs;
import uk.gov.digital.ho.egar.flyway.support.FlywaySupport;

import javax.sql.DataSource;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class 'supports' the FlywayRunner.
 * It allows a Postgres database to be supported and migrated.
 */
public class PostgresFlywaySupport implements FlywaySupport {

	private static final Logger logger = LoggerFactory.getLogger(PostgresFlywaySupport.class);
	
	private final DataSource datasource;

	private final URI jdbcUri;

	private final FlywayRunnerArgs flywayRunnerArgs ;

	public PostgresFlywaySupport(DataSource datasource, URI jdbcUri, FlywayRunnerArgs flywayRunnerArgs) {
		this.datasource = datasource;
		this.jdbcUri = jdbcUri;
		this.flywayRunnerArgs = flywayRunnerArgs;
	}

	public boolean createDatabaseIfRequired() throws SQLException {
		
		logger.debug("createDatabaseIfRequired()");
		String dbServerUrl = String.format("jdbc:postgresql://%s:%d/", 
				jdbcUri.getHost(),
				((jdbcUri.getPort() != -1) ? jdbcUri.getPort() : 5432));
		Connection conn = DriverManager.getConnection(dbServerUrl, flywayRunnerArgs.getUsername(), flywayRunnerArgs.getPassword());
		//Only retrieve the db name
		String schemaName = jdbcUri.getPath().split(";")[0];
		//Removes "/" prefix
		schemaName = schemaName.startsWith("/") ? schemaName.substring(1) : schemaName;
		
		try {
			// Database exists?
			if ( !checkDatabaseExists(conn,schemaName) )
			{
				// As db does not exist do we procede?
				String[] arguments = flywayRunnerArgs.getFlywayProperties();
				for(String argument:arguments){
					switch (argument){
						case "clean"   :
						case "info"    :
						case "validate":
							logger.info("No data base at " + jdbcUri.toString() );
							return false ;
					}
				}

				// No ... 
				conn.close();

				if ( logger.isDebugEnabled() ) logger.debug("createDatabaseIfRequired() - does not exist " + jdbcUri.toString() );
				
				if (!flywayRunnerArgs.areAdminCredentialsSet()){ 
			        throw new UnsupportedOperationException("Admin db credentials not specified. Unable to create DB."); 
				}
				
				conn = DriverManager.getConnection(dbServerUrl, flywayRunnerArgs.getUsername(), flywayRunnerArgs.getPassword());
				createDatabase(conn,schemaName);
			}
		}
		finally
		{
			if ( conn != null )
			{
				conn.close();
			}
		}
		
		return true ;
	}

	private void createDatabase(Connection conn, String dbName) throws SQLException {
		
		Statement stmt = null ; 
		try {
			stmt = conn.createStatement();
			stmt.execute("CREATE DATABASE " + dbName);	
			logger.info( "database created:" + dbName );
		}
		finally
		{
			if ( stmt != null )
				stmt.close();
		}
		
	}

	private boolean checkDatabaseExists(Connection connection, String databaseTargetName ) throws SQLException {
		
		ResultSet resultSet = null ;
		PreparedStatement pst = null ;
		
		try {
			String query = "SELECT datname FROM pg_database WHERE datistemplate = false;";
			pst = connection.prepareStatement(query);
			
			resultSet = pst.executeQuery();

			//iterate each catalog in the ResultSet
			while (resultSet.next()) {
			  // Get the database name, which is at position 1
			  String databaseName = resultSet.getString(1);
			  if ( databaseName.equals( databaseTargetName )) 
				  return true ;
			}			
		}
		finally
		{
			if ( pst != null )
				pst.close();
			if ( resultSet != null )
				resultSet.close();
		}		
		
		return false;
	}

	@Override
	public void executeFlyway() {
		
		logger.debug("executeFlyway()");
		
		String[] arguments = flywayRunnerArgs.getFlywayProperties();
		Flyway flyway = createFlyway();
		for(String argument:arguments){
			
			logger.info("Performing Flyway:" + argument );
			
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
