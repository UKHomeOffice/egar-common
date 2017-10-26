package uk.gov.digital.ho.egar.services.v1.gar;

import java.util.List;
import java.util.UUID;

public interface GARDraft {
	UUID getId();
    UUID getFlightId();
    UUID getCaptain();
    List<UUID> getCrewIds();
    List<UUID> getPassengersIds();
    List<UUID> getSupportingDocIds();
}
