package uk.gov.digital.ho.egar.services.v1.people;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Interface for any method signatures and constants are related to travellers in a GAR
 * @author Keshava.Grama
 *
 */
public interface Traveller extends Person {

	UUID getId();

	Address getUkAddress();

	String getNationality();

	LocalDate getTravelDocumentExipiryDate();

	String getTravelDocumentIssuingCountry();

	String getTravelDocumentNumber();

	DocumentType getDocumentType();

	TravellerType getTravellerType();
}
