package uk.gov.digital.ho.egar.flyway.support;

import java.sql.SQLException;

public interface FlywaySupport {

	/**
	 * @return true is the db can be created or exists and the support process should continue.
	 */
	boolean createDatabaseIfRequired() throws SQLException;

	void executeFlyway();
}
