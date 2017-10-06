package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.Date;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarFlight;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Flight record for a GAR, removed if not reused in 12 months
 * @author Keshava.Grama
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EgarFlight extends EgarPersistedRecords implements IEgarFlight {
	UUID id;

	Date departureDateTimeUTC;
	Date arrivalDateTimeUTC;
	
	EgarGeographicLocation from;
	EgarGeographicLocation to;
		
	EgarAircraft aircraft;
	boolean aircraftInFreeCirculation;
	boolean ukVatPaid;
	EgarReasonForFlight reason;
}
