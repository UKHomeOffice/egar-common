package uk.gov.digital.ho.egar.datamodel;

import uk.gov.digital.ho.egar.datamodel.PurgePeriod;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Parent interface for all persisted records in the database. It will be used to automate the cleanup of records
 * @author Keshava.Grama
 *
 */
public interface PersistedRecord {

	UUID getUuidOfSourceUser();

	LocalDateTime getPurgeDate();

	PurgePeriod getPurgePeriod();
}
