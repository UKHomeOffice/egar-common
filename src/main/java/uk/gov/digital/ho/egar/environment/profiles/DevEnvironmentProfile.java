package uk.gov.digital.ho.egar.environment.profiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

/**
 * @deprecated Use #NotProdEnvironmentProfile
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Profile("dev")
@Deprecated
public @interface DevEnvironmentProfile {

}
