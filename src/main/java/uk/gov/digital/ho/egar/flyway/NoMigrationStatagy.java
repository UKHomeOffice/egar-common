package uk.gov.digital.ho.egar.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@Configuration
public class NoMigrationStatagy implements FlywayMigrationStrategy {

	@Override
	public void migrate(Flyway fly) {
		// No Operation
		Assert.notNull(fly,"No flyway");
		//fly.validate();
	}
}
