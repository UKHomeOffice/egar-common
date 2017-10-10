package uk.gov.digital.ho.egar.services.v1.flight;

import uk.gov.digital.ho.egar.constants.ServicePathConstants;

/**
 * Interface for any method signatures and constants that the are relevant to a flight
 * @author Keshava.Grama
 *
 */
public interface Flight {
	public static final String ROOT_SERVICE_NAME = "flight";
	public static final String ROOT_PATH = 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ServicePathConstants.ROOT_SERVICE_API + 
			ServicePathConstants.ROOT_PATH_SEPERATOR + 
			ROOT_SERVICE_NAME;
	/*
	UUID getId();

	LocalDateTime getDepartureDateTimeUTC();

	LocalDateTime getArrivalDateTimeUTC();

	GeographicLocation getFrom();

	GeographicLocation getTo();

	Aircraft getAircraft();

	boolean isAircraftInFreeCirculation();

	boolean isUkVatPaid();

	ReasonForFlight getReason();
	*/
}
