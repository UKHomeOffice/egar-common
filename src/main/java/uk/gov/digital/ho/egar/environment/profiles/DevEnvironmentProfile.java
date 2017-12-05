package uk.gov.digital.ho.egar.environment.profiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

/**
 * Environment profile to setup the use of transient data sources, for use during:
 * - Development, will set the properties in backend api's to use H2
 * - Running unit tests to validate the backend services during container creation
 * - Mocking any workflow activity (use of dummy client/ security filter etc).
 * @deprecated Use #NotProdEnvironmentProfile
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Profile("dev")
@Deprecated
public @interface DevEnvironmentProfile {

}
