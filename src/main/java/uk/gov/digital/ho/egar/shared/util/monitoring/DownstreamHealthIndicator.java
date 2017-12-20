/**
 * 
 */
package uk.gov.digital.ho.egar.shared.util.monitoring;

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
    	return fetchHealth(this.restTemplate,this.downStreamUrl);
    }
    
    public static Health fetchHealth(RestTemplate restTemplate,String downStreamUrl) {
        try {
            JsonNode resp = restTemplate.getForObject(downStreamUrl + "/health", JsonNode.class); 
            if (resp.get("status").asText().equalsIgnoreCase("UP")) {
                return Health.up().build();
            } 
        } catch (Exception ex) {
            return Health.down(ex).build();
        }
        return Health.down().build();
    } 
    
    /**
     * Fetches the Info endpoint data from the remote.
     * @return null on failure.
     */
    public static JsonNode fetchRawHealth(RestTemplate restTemplate,String downStreamUrl) {
    	
    	JsonNode resp = null ;
    	
        try {
            resp = restTemplate.getForObject(downStreamUrl + "/health", JsonNode.class); 
            
        } catch (Exception ex) {
        	// Swollow
        }
        return resp;
    } 
    /**
     * Fetches the Info endpoint data from the remote.
     * @return null on failure.
     */
    public static JsonNode fetchInfo(RestTemplate restTemplate,String downStreamUrl) {
    	
    	JsonNode resp = null ;
    	
        try {
            resp = restTemplate.getForObject(downStreamUrl + "/info", JsonNode.class); 
            
        } catch (Exception ex) {
        	// Swollow
        }
        return resp;
    } 
    
}
