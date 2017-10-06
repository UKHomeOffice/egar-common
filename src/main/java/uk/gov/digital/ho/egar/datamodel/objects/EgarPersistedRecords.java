package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarPersistedRecord;

/**
 * Parent for all persisted records, is used to implement the periodic purge process.
 * @author Keshava.Grama
 *
 */
@Data
public abstract class EgarPersistedRecords implements IEgarPersistedRecord{
	UUID uuidOfSourceUser;
	Date purgeDate;
	PurgePeriod purgePeriod;
	
	/**
	 * Default purge period set to twelve months
	 */
	public EgarPersistedRecords(){
		this.purgePeriod = PurgePeriod.TWELVE_MONTHS;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 1);
		this.purgeDate = cal.getTime();		
	}
	
}
