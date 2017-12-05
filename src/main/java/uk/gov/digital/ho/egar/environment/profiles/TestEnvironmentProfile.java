package uk.gov.digital.ho.egar.environment.profiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

/**
 * Environment profile to setup the use of persistent data test data sources:
 * - Use to set default logging levels to debug 
 * - Returning stack traces of errors in responses to the front end to enable error identification 
 * @deprecated Use #NotProdEnvironmentProfile
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Profile("test")
public @interface TestEnvironmentProfile {

}
