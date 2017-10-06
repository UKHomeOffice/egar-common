package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.Date;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarRegisteredUser;

import lombok.Data;

/**
 * EgarUser basic information about the person logging into eGAR and submitting GAR's
 * @author Keshava.Grama
 *
 */
@Data
public class EgarUser implements IEgarRegisteredUser {
	String username;
	String passwordHash;
	String salt;
	
	int numberOfFailedLoginAttempts;
	boolean accountLocked;
	boolean passwordExpired;
	
	Date passwordExpiryDate;
	
	/**
	 * This uuid field is used as the key to search all records entered by this user
	 */
	UUID uuidOfUser;
	
	/**
	 * Optional field 
	 */
	EgarPerson userDetails;

	public AuthenticationState authUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changePassword(String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
