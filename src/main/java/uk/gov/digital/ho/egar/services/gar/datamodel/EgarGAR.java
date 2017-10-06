package uk.gov.digital.ho.egar.services.gar.datamodel;

import java.util.List;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.objects.EgarPersistedRecords;
import uk.gov.digital.ho.egar.services.flight.datamodel.EgarAircraft;
import uk.gov.digital.ho.egar.services.gar.IEgarGAR;
import uk.gov.digital.ho.egar.services.people.datamodel.EgarTraveller;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * GAR, purged after 3 months
 * @author Keshava.Grama
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EgarGAR extends EgarPersistedRecords implements IEgarGAR {
	UUID id;
	EgarAircraft aircraft;
	EgarTraveller captain;
	List<EgarTraveller> crew;
	List<EgarTraveller> passangers;
	
	public EgarGAR(){
		this.setPurgePeriod(PurgePeriod.THREE_MONTHS);
	}
}
