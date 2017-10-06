package uk.gov.digital.ho.egar.constants;

import java.util.Calendar;

/**
 * Constants used to configure the JWT validity and duration. 
 * Default values if the config does not provide these
 * @author Keshava.Grama
 *
 */
public interface EgarWEBToken {
	public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	
	public static final int REFRESH_TOKEN_VALIDITY_DURATION = 10;
	public static final int REFRESH_TOKEN_VALIDITY_UNIT = Calendar.MINUTE;
	
	public static final int ACCESS_TOKEN_VALIDITY_DURATION = 2;
	public static final int ACCESS_TOKEN_VALIDITY_UNIT = Calendar.MINUTE;
}
