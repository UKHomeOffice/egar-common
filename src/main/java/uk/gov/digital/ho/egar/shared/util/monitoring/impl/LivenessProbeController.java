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
 * <p>The issue here is the services are offline so the behaviour of the service must reflect that while not having K8 take the servicve offline.
 * </p>
 * <p>In many cases, it makes sense to complement readiness probes with liveness probes. Despite the similarities, they actually function independently. While readiness probes take a more passive approach, liveness probes will actually attempt to restart a pod if it fails.</p>
 * <p>Here’s what this might look like in a real life failure scenario. Let’s say our API encounters a fatal exception when processing a request.</p>
 * <ol>
 * <li>Readiness probe fails.</li>
 * <li>Kubernetes stops routing traffic to the pod.</li>
 * <li>Liveness probe fails.</li>
 * <li>Kubernetes restarts the pod.</li>
 * <li>Readiness probe succeeds.</li>
 * <li>Kubernetes starts routing traffic to the pod again.</li>
 * </ol>
 */
@RestController
@RequestMapping(LivenessProbe.STANDARD_URI)
@Api(value = LivenessProbe.STANDARD_URI)
public class LivenessProbeController extends AbstractHealthProbe implements LivenessProbe {

	/**
	 * The spring boot actuator endpoint for health.
	 */
	@Autowired
	private HealthMvcEndpoint healthMvcEndpoint;

	@Override
	@GetMapping
	public ResponseEntity<Void> performLivenessProbe(HttpServletRequest request, Principal principal) {

		Health health = invokeHealthEndpoint(request, principal);

		if (health == null) {
			return ResponseEntity.badRequest().build();
		} else if (Status.UP.equals(health.getStatus())|| Status.OUT_OF_SERVICE.equals(health.getStatus())) {
			// Both indicate the service has not failed.
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
