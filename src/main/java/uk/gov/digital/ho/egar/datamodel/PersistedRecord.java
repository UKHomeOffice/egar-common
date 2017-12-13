package uk.gov.digital.ho.egar.datamodel;

import uk.gov.digital.ho.egar.datamodel.PurgePeriod;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Parent interface for all persisted records in the database. It will be used to automate the cleanup of records
 * @author Keshava.Grama
 * @deprecated Not needed at this time as it is not part of requirements. Remove in a future sprint.
 */
public interface PersistedRecord extends Serializable{

	UUID getUuidOfSourceUser();

	LocalDateTime getPurgeDate();

	PurgePeriod getPurgePeriod();
}
