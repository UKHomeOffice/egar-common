package uk.gov.digital.ho.egar.flyway.support;

import javax.sql.DataSource;


public interface FlywaySupportFactory  {

	FlywaySupport createFlywaySupport(DataSource datasource);
}
