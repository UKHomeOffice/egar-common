package uk.gov.digital.ho.egar.services.v1.flight;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Interface for any method signatures and constants that the are relevant to a flight
 * @author Keshava.Grama
 *
 */
public interface Flight {
	UUID getId();

	LocalDateTime getDepartureDateTimeUTC();

	LocalDateTime getArrivalDateTimeUTC();

	GeographicLocation getFrom();

	GeographicLocation getTo();

	UUID getAircraftId();

	boolean isAircraftInFreeCirculation();

	boolean isUkVatPaid();

	ReasonForFlight getReason();
	
}
