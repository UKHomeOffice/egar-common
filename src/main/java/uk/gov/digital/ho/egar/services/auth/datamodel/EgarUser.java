package uk.gov.digital.ho.egar.services.auth.datamodel;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
import uk.gov.digital.ho.egar.services.auth.IEgarRegisteredUser;

/**
 * EgarUser basic information about the person logging into eGAR and submitting GAR's
 * @author Keshava.Grama
 *
 */
@Data
public abstract class EgarUser implements IEgarRegisteredUser {
	protected String username;
	protected String passwordHash;
	protected String salt;
	
	protected int numberOfFailedLoginAttempts;
	protected boolean accountLocked;
	protected boolean passwordExpired;
	
	protected  Date passwordExpiryDate;
	protected UUID uuidOfUser;
	
	public EgarUser() {
		this.uuidOfUser = UUID.randomUUID();
	}
	
	public AuthenticationState authUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changePassword(String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
