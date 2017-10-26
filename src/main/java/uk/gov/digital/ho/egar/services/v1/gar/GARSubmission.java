package uk.gov.digital.ho.egar.services.v1.gar;

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
