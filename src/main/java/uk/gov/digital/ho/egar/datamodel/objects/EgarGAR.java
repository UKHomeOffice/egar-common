package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.List;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarGAR;

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
		this.purgePeriod = PurgePeriod.threeMonths;
	}
}
