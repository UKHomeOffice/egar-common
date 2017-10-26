package uk.gov.digital.ho.egar.services.v1.gar;

import uk.gov.digital.ho.egar.services.v1.flight.Flight;
import uk.gov.digital.ho.egar.services.v1.people.Traveller;
import uk.gov.digital.ho.egar.services.v1.supportingdocs.SupportingDocs;

import java.util.List;
import java.util.UUID;

/**
 * Interface for any method signatures and constants that a GAR entry will need
 * @author Keshava.Grama
 *
 */
public interface GARSubmission {

    UUID getId();

    FlightSnapShot getFlight();

    TravellerSnapShot getCaptain();

    List<TravellerSnapShot> getCrew();

    List<TravellerSnapShot> getPassengers();

    List<SupportingDocsSnapShot> getSupportingDocs();
    
    String getCBPReferenceNumber();
}
