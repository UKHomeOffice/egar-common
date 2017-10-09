package uk.gov.digital.ho.egar.services.v1.people;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Interface for any method signatures and constants for all person records in eGAR
 * @author Keshava.Grama
 *
 */
public interface Person {

	UUID getUuid();

	String getGivenNames();

	String getSurname();

	Gender getGender();

	LocalDate getDateOfBirth();

}
