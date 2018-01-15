package uk.gov.digital.ho.egar.flyway;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class FlywayRunnerArgs {
	

	/*
	 * Checks there are command line arguments and then checks if one of them is a flyway argument
	 */
	public static boolean hasFlywayArg(String[] args) {

		if (args.length == 0) return false;
		for (String arg:args)
		{
			if ( FlywayRunnerArgs.isFlyWayArgument(arg)) return true ;
		}
		return false;
	}
	
	/**
	 * @param flywayProperties List of command line flyway operations
	 */
	 @Value("${flyway.properties}")
     private String flywayProperties;

     public String[] getFlywayProperties() {
         return this.flywayProperties.split(",");
     }
     
     /**
 	 * @param activeProfiles List of active spring profiles
 	 */
 	 @Value("${spring.profiles.active}")
      private String activeProfiles;

      public String getActiveProfiles() {
          return this.activeProfiles;
      }

	public static boolean isFlyWayArgument(String arg) {
		return arg.startsWith("--flyway.properties");
	}


	/**
	 * @param activeProfiles List of active spring profiles
	 */
	@Value("${flyway.schemas}")
	private String schemas;


	@Value("${flyway.baseline-on-migrate}")
	private String baselineOnMigrate;

	@Value("${flyway.database.admin.username:#{null}}")
	private String adminUsername;

	@Value("${flyway.database.admin.password:#{null}}")
	private String adminPassword;

	public String[] getSchemas() {
		return schemas.split(",");
	}

	public boolean getBaselineOnMigrate() {
		return "true".equalsIgnoreCase(baselineOnMigrate);
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public boolean areAdminCredentialsSet() {
		return StringUtils.isNotBlank(adminUsername) && StringUtils.isNotBlank(adminPassword);
	}
}
