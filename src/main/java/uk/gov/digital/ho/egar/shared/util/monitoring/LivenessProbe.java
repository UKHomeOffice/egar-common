/**
 *
 */
package uk.gov.digital.ho.egar.shared.util.monitoring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import java.security.Principal;

/**
 * <h2>Liveness Probe</h2>
 * <p>
 * Include only those checks which you think, if fails, will get cured with a pod restart.
 * There is nothing wrong in having a new end point that always return an HTTP 200, which will serve as a
 * liveness probe end point; provided you have independent monitoring and alert is in place for other services
 * on which your first service depends on.
 * Where does a simple http 200 liveness helps?
 * Well, if your application is a non-reactive thread-based application (servlet based application
 * - like application runs on tomcat - which is spring boot's default choice),
 * in the case of highload it may become unresponsive and pod restart will help.
 * If you don't have memory configured while you starts your application;
 * in case of highload, application may outrun the pod's allocated memory and app may become unresponsive
 * and pod restart will help.
 *
 * @see https://stackoverflow.com/questions/46014206/kubernetes-liveness-and-readiness-probe-implementation
 * @see https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-probes/
 * @see https://github.com/UKHomeOffice/technical-service-requirements/blob/master/docs/monitoring_metrics.md
 */
public interface LivenessProbe {

    /**
     * The liveness path that is used by Kubernetes.
     */
    public static final String STANDARD_URI = "/healthz";


    /**
     * Performs a liveness probe which responds with the health of the application.
     * This should be a 200 response when the application is healthy.
     * @return The health of the application.
     */
    ResponseEntity<Void> performLivenessProbe(HttpServletRequest request, Principal principal);
}


