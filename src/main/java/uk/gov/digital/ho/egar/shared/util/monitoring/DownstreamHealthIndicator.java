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
    
}
