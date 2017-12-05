package uk.gov.digital.ho.egar.services.v1.flight;

import java.util.UUID;

/**
 * Interface for any method signatures and constants that the are relevant to a flight
 * @author Keshava.Grama
 * @deprecated Will be removed in the next release.
 *
 */
public interface Flight {
	UUID getUuid();

	WhereWhen getFrom();

	WhereWhen getTo();

	Aircraft getAircraft();

	boolean isAircraftInFreeCirculation();

	boolean isUkVatPaid();
	
	boolean isHazardousGoodsOnBoard(); 
	
	boolean isWithinCTA();
	
	ReasonForFlight getReason();
	
}
