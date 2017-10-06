package uk.gov.digital.ho.egar.environment.profiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Profile("dev")
public @interface DevEnvironmentProfile {

}
