package uk.gov.digital.ho.egar.services.v1.gar;

import java.util.List;
import java.util.UUID;

/**
 * @deprecated Will be removed in the next release.
 */
public interface GARDraft {
	UUID getId();
    UUID getFlightId();
    UUID getCaptain();
    List<UUID> getCrewIds();
    List<UUID> getPassengersIds();
    List<UUID> getSupportingDocIds();
}
