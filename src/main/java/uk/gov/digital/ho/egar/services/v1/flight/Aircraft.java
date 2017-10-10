package uk.gov.digital.ho.egar.services.v1.flight;

import uk.gov.digital.ho.egar.constants.ServicePathConstants;

/**
 * Interface for any method signatures that the aircraft object will need. 
 * @author Keshava.Grama
 *
 */
public interface Aircraft {
	public static final String ROOT_SERVICE_NAME = "aircraft";
	public static final String ROOT_PATH = 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ServicePathConstants.ROOT_SERVICE_API + 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ROOT_SERVICE_NAME;
    
	/*
	UUID getUuid();

    AircraftType getAircraftType();

    String getRegistrationNumber();

    String getUsualBase();

    boolean isEuTaxed();

    Person getResponsiblePerson();

    String getCrewContactInUK();
    */
}
