package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarAircraft;
import uk.gov.digital.ho.egar.datamodel.lookup.objects.EgarAircraftType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Aircraft record for a GAR, removed if not reused in 12 months
 * @author Keshava.Grama
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EgarAircraft extends EgarPersistedRecords implements IEgarAircraft {
	UUID uuid;
	EgarAircraftType aircraftType;
	String registrationNumber;
	String usualBase;
	boolean euTaxed;
	
	EgarPerson responsiblePerson;
	String crewContactInUK;
}
