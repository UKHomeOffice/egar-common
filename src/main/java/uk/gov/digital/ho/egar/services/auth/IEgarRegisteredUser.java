package uk.gov.digital.ho.egar.services.auth;

/**
 * Registered users may have a minimal profile as their details are not required in eGAR if they are not 
 * travelling/ are not in a GAR
 * @author Keshava.Grama
 *
 */
public interface IEgarRegisteredUser {
	public enum AuthenticationState{
		AUTHENTICATION_FAILED,
		ACCOUNT_LOCKED,
		PASSWORD_CHANGE_REQUIRED
	}
	
	public AuthenticationState authUser();
	public boolean changePassword(String newPassword);
	
}
