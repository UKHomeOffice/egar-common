package uk.gov.digital.ho.egar.flyway.support;

import java.sql.SQLException;

public interface FlywaySupport {

	void createDatabaseIfRequired() throws SQLException;

	void executeFlyway();
}
