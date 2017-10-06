package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarPersistedRecord;

/**
 * Parent for all persisted records, is used to implement the periodic purge process.
 * @author Keshava.Grama
 *
 */
public class EgarPersistedRecords implements IEgarPersistedRecord{
	UUID uuidOfSourceUser;
	Date purgeDate;
	PurgePeriod purgePeriod;
	
	/**
	 * Default purge period set to twelve months
	 */
	EgarPersistedRecords(){
		this.purgePeriod = PurgePeriod.twelveMonths;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 1);
		this.purgeDate = cal.getTime();		
	}
	
}
