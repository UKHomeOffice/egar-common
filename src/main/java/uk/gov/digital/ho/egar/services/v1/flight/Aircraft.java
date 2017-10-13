package uk.gov.digital.ho.egar.services.v1.flight;

import java.util.UUID;

import uk.gov.digital.ho.egar.services.v1.people.Person;
import uk.gov.digital.ho.egar.services.v1.referencedata.AircraftType;

/**
 * Interface for any method signatures that the aircraft object will need. 
 * @author Keshava.Grama
 *
 */
public interface Aircraft {
	UUID getUuid();

    AircraftType getAircraftType();

    String getRegistrationNumber();

    String getUsualBase();

    boolean isEuTaxed();

    Person getResponsiblePerson();

    String getCrewContactInUK();
    
}
