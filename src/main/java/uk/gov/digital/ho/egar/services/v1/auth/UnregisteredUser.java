package uk.gov.digital.ho.egar.services.v1.auth;

import uk.gov.digital.ho.egar.constants.ServicePathConstants;

/**
 * This is base interface to indicating that there is a service to register users of 
 * eGAR. Add method signatures for stuff that must be supported on the controller 
 * @author Keshava.Grama
 *
 */
public interface UnregisteredUser {
	public static final String ROOT_SERVICE_NAME = "register";
	public static final String ROOT_PATH = 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ServicePathConstants.ROOT_SERVICE_API + 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ROOT_SERVICE_NAME;
}
