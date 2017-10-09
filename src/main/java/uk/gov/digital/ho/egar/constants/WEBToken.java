package uk.gov.digital.ho.egar.constants;

import java.util.Calendar;

/**
 * Constants used to configure the JWT validity and duration. 
 * Default values if the config does not provide these
 * @author Keshava.Grama
 *
 */
public interface WEBToken {
	String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	
	int REFRESH_TOKEN_VALIDITY_DURATION = 10;
	int REFRESH_TOKEN_VALIDITY_UNIT = Calendar.MINUTE;

	int ACCESS_TOKEN_VALIDITY_DURATION = 2;
	int ACCESS_TOKEN_VALIDITY_UNIT = Calendar.MINUTE;
	
}
