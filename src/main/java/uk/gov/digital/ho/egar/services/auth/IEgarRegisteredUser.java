package uk.gov.digital.ho.egar.services.auth;

import uk.gov.digital.ho.egar.constants.ServicePathConstants;

/**
 * Registered users may have a minimal profile as their details are not required in eGAR if they are not 
 * travelling/ are not in a GAR
 * @author Keshava.Grama
 *
 */
public interface IEgarRegisteredUser {
	public static final String ROOT_SERVICE_NAME = "auth";
	public static final String ROOT_PATH = 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ServicePathConstants.ROOT_SERVICE_API + 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ROOT_SERVICE_NAME;
	public enum AuthenticationState{
		AUTHENTICATION_FAILED,
		ACCOUNT_LOCKED,
		PASSWORD_CHANGE_REQUIRED
	}
	
	public AuthenticationState authUser();
	public boolean changePassword(String newPassword);
	
}
