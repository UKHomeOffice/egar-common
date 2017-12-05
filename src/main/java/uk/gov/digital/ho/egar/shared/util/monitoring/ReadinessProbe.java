/**
 * 
 */
package uk.gov.digital.ho.egar.shared.util.monitoring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import java.security.Principal;

/**
 * <h2>Readiness Probe</h2>
 * There are 2 aspects to it.
 * <ol>
 * <li>Let's assume that authentication enabled at your second service and your first service (where your health check is) 
 * has to be configured properly to authenticate with the second service. 
 * Lets' just say, in a subsequent deployment you screwed up authheader variable name which you were supposed to read from the configmap or secret. 
 * And you are doing a rolling update. 
 * If you have the second service's http200 also included in the health check then that will prevent the screwed-up version of the deployment from going live; 
 * you old version will keep running as your newer version will never make it across the health-check. We may not even need to go that complicated to authentication and all, 
 * let's just say url of the second service is hard coded in the first service, and you screwed up that url in subsequent releases of your first service, 
 * this added check in your health check will prevent the buggy version from going live.
 * </li>
 * <li>On the other hand, Let's assume that your first service has numerous other functionalities and this second service being down for a 
 * few hours will not affect any significant functionality that first service offers. Then, of course you need to exclude the second service's liveness 
 * from first service's health check.
 * </li>
 * </ol>
 * Either way, you need to set up proper alerting and monitoring for both the services. This will help to decide when humans should intervene.
 * 
 * @see https://github.com/UKHomeOffice/technical-service-requirements/blob/master/docs/monitoring_metrics.md
 */
public interface ReadinessProbe  {

	/**
	 * The readiness path that Kubernetes uses.
	 */
	public static final String STANDARD_URI = "/readiness" ;

	/**
	 * Performs a readiness probe which responds with the health of the application.
	 * This should be a 200 response when the application is ready to receive requests.
	 * @return The health of the application.
	 */
	ResponseEntity<Void> performReadinessProbe(HttpServletRequest request, Principal principal);
}
