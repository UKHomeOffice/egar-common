package uk.gov.digital.ho.egar.flyway.support;

import javax.sql.DataSource;


public interface FlywaySupportFactory  {

	/**
	 * @param datasource
	 * @return the Support object.
	 * @throws UnsupportedOperationException if the type of database is not supported.
	 */
	FlywaySupport createFlywaySupport(DataSource datasource);
}
