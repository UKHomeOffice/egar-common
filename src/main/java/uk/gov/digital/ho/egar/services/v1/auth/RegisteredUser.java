package uk.gov.digital.ho.egar.services.v1.auth;

import uk.gov.digital.ho.egar.constants.ServicePathConstants;

/**
 * Registered users may have a minimal profile as their details are not required in eGAR if they are not 
 * travelling/ are not in a GAR
 * @author Keshava.Grama
 *
 */
public interface RegisteredUser {
	public static final String ROOT_SERVICE_NAME = "authenticated";
	public static final String ROOT_PATH = 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ServicePathConstants.ROOT_SERVICE_API + 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ROOT_SERVICE_NAME;
	/*String getUsername();

	String getPasswordHash();

	String getSalt();

	int getNumberOfFailedLoginAttempts();

	boolean isAccountLocked();

	boolean isPasswordExpired();

	LocalDateTime getPasswordExpiryDate();

	UUID getUuidOfUser();

	AuthenticationState authUser();

	boolean changePassword(String newPassword);
	*/
}
