package uk.gov.digital.ho.egar.environment.profiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

/**
 * Environment profile to setup the use of persistent data prod data sources:
 * - Use to set default logging levels to error 
 * - Return business  
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Profile("beta")
public @interface BetaEnvironmentProfile {

}
