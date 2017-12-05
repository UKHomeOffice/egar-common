/**
 * 
 */
package uk.gov.digital.ho.egar.shared.util.monitoring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import uk.gov.digital.ho.egar.shared.util.monitoring.LivenessProbe;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * A rest controller that exposes the liveness endpoint for use with Kubernetes.
 */
@RestController
@RequestMapping(LivenessProbe.STANDARD_URI)
@Api(value = LivenessProbe.STANDARD_URI)
public class LivenessProbeController implements LivenessProbe {

	/**
	 * The spring boot actuator endpoint for health.
	 */
	@Autowired
	private HealthMvcEndpoint healthMvcEndpoint;

	@Override
	@GetMapping
	public ResponseEntity<Void> performLivenessProbe(HttpServletRequest request, Principal principal) {

		Health health = null;
		try {
			// End point object returns a health object and then converts to Json.
			// This will break if Spring changes.
			health = (Health) healthMvcEndpoint.invoke(request, principal);
		} catch (Exception e) {
			// Swollow
		}

		if (health == null) {
			return ResponseEntity.badRequest().build();
		} else if (Status.UP.equals(health.getStatus())) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
