package uk.gov.digital.ho.egar.flyway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import uk.gov.digital.ho.egar.flyway.support.FlywaySupport;
import uk.gov.digital.ho.egar.flyway.support.FlywaySupportFactory;


import javax.sql.DataSource;

@Configuration
@SpringBootApplication(exclude = {EmbeddedServletContainerAutoConfiguration.class, 
		WebMvcAutoConfiguration.class,
		// Remove the Autowiring of Hibernate & JPA.
		JpaRepositoriesAutoConfiguration.class, 
		HibernateJpaAutoConfiguration.class
})
public class FlywayRunner implements CommandLineRunner  {

	public static void main(String[] args) {
		/*
		 * Runs application with flyway but without web services
		 */
		new SpringApplicationBuilder(FlywayRunner.class).web(false).run(args);

	}

	@Autowired
	private DataSource datasource;

	@Autowired
	private FlywaySupportFactory flywaySupportFactory;
	
	@Override
	public void run(String... arg0) throws Exception {

		Assert.notNull(datasource,"No datasource.");

		FlywaySupport flywaySupport = flywaySupportFactory.createFlywaySupport(datasource);

		flywaySupport.createDatabaseIfRequired();
		flywaySupport.executeFlyway();

	}


}
