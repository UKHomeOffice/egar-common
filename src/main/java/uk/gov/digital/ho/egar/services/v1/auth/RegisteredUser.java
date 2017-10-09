package uk.gov.digital.ho.egar.services.v1.auth;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Registered users may have a minimal profile as their details are not required in eGAR if they are not 
 * travelling/ are not in a GAR
 * @author Keshava.Grama
 *
 */
public interface RegisteredUser {

	String getUsername();

	String getPasswordHash();

	String getSalt();

	int getNumberOfFailedLoginAttempts();

	boolean isAccountLocked();

	boolean isPasswordExpired();

	LocalDateTime getPasswordExpiryDate();

	UUID getUuidOfUser();

	AuthenticationState authUser();

	boolean changePassword(String newPassword);
	
}
