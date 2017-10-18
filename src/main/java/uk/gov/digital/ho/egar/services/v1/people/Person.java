package uk.gov.digital.ho.egar.services.v1.people;

import java.time.LocalDate;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.PersistedRecord;

/**
 * Interface for any method signatures and constants for all person records in eGAR
 * @author Keshava.Grama
 *
 */
public interface Person extends PersistedRecord{

	UUID getUuid();

	String getGivenNames();

	String getSurname();

	Gender getGender();

	LocalDate getDateOfBirth();

}
