package uk.gov.digital.ho.egar.shared.util.monitoring.impl;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.ResponseEntity;


abstract class AbstractHealthProbe {

	private static final Logger logger = LoggerFactory.getLogger(ReadinessProbeController.class);
	/**
	 * The spring boot actuator endpoint for health.
	 */
	@Autowired
	private HealthMvcEndpoint healthMvcEndpoint;

	protected AbstractHealthProbe() {
		super();
	}

	protected Health invokeHealthEndpoint(HttpServletRequest request, Principal principal) {
		Health health = null;
		try {
			// End point object returns a health object and then converts to
			// Json.
			// This will break if Spring changes.
			Object ret = healthMvcEndpoint.invoke(request, principal);
			
			if ( ret instanceof Health )
				{
				health = (Health) ret ;
				}
			else
			if ( ret instanceof ResponseEntity )
			{
				ResponseEntity<?> resp = (ResponseEntity<?>) ret ;
				if ( resp.getBody() instanceof Health )
				{
				health = (Health) resp.getBody() ;
				}
			}
			
		} catch (Exception ex) {
			// Swollow
			logger.debug(ex.getMessage());
		}
		return health;
	}

}