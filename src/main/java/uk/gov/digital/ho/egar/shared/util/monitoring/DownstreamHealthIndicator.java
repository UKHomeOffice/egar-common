/**
 * 
 */
package uk.gov.digital.ho.egar.shared.util.monitoring;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

public class DownstreamHealthIndicator implements HealthIndicator {

    private RestTemplate restTemplate;
    private String downStreamUrl;

    @Autowired
    public DownstreamHealthIndicator(RestTemplate restTemplate, String downStreamUrl) {
        this.restTemplate = restTemplate;
        this.downStreamUrl = downStreamUrl;
    }

    @Override
    public Health health() {
    	try {
			return fetchHealth(this.restTemplate,new URL(this.downStreamUrl));
		} catch (MalformedURLException ex) {
			return Health.down(ex).build();
		}
    }

    /**
     * Fetches the Json data from the microservice health endpoint data from the remote.
     * @param The URL of the endpoint with out the URL.
     * @return null on failure.
     * @throws MalformedURLException 
     */
    public static Health fetchHealth(RestTemplate restTemplate,String downStreamUrl) throws MalformedURLException {
    	
    	return fetchHealth(restTemplate,new URL(downStreamUrl));
    }
    
    /**
     * Fetches the actual 
     * @param restTemplate
     * @param downStreamUrl
     * @return A health service object.
     */
    public static Health fetchHealth(RestTemplate restTemplate,URL downStreamUrl) {
    	
    	if ( downStreamUrl == null )
    		return Health.down(new Exception("Service URL not configured.")).build();
    	
        try {
        	// Fetch the response directly and deal with the problems.
        	URL healthURL = new URL(downStreamUrl,"/health");
        	JsonNode resp = restTemplate.getForObject(healthURL.toString(), JsonNode.class); 
            if (resp.get("status").asText().equalsIgnoreCase("UP")) {
                return Health.up().build();
            } 
        } catch (Exception ex) {
            return Health.down(new Exception(String.format("Can not contact service at %s",downStreamUrl),ex)).build();
        }
        return Health.down().build();
    } 

    /**
     * Fetches the Json data from the microservice health endpoint data from the remote.
     * @param The URL of the endpoint with out the URL.
     * @return null on failure.
     * @throws MalformedURLException 
     */
    public static JsonNode fetchRawHealth(RestTemplate restTemplate,String downStreamUrl) throws MalformedURLException {
    	
    	return fetchRawHealth(restTemplate,new URL(downStreamUrl));
    }
    	
    /**
     * Fetches the Json data from the microservice health endpoint data from the remote.
     * @param The URL of the endpoint with out the URL.
     * @return null on failure.
     */
    public static JsonNode fetchRawHealth(RestTemplate restTemplate,URL downStreamUrl) {
    	
    	JsonNode resp = null ;
    	
    	
        try {
        	URL healthURL = new URL(downStreamUrl,"/health");
            resp = restTemplate.getForObject(healthURL.toString(), JsonNode.class); 
            
        } catch (Exception ex) {
        	// Swollow
        }
        return resp;
    } 
    /**
     * Fetches the Info endpoint data from the remote.
     * @return null on failure.
     * @throws MalformedURLException 
     */
    public static JsonNode fetchInfo(RestTemplate restTemplate,String downStreamUrl) throws MalformedURLException {
    	return fetchInfo(restTemplate,new URL(downStreamUrl));
    }
    
    /**
     * Fetches the Info endpoint data from the remote.
     * @return null on failure.
     */
    public static JsonNode fetchInfo(RestTemplate restTemplate,URL downStreamUrl) {
    	
    	JsonNode resp = null ;
    	
        try {
        	URL infoURL = new URL(downStreamUrl,"/info");
            resp = restTemplate.getForObject(infoURL.toString(), JsonNode.class); 
            
        } catch (Exception ex) {
        	// Swollow
        }
        return resp;
    } 
    
}
