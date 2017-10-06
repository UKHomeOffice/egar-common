package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.Date;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarPerson;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * EgarPerson is the holder for relatively static data for a person in GAR
 * Can potentailly have a many to one relationship with EgarTraveller
 * @author Keshava.Grama
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EgarPerson extends EgarPersistedRecords implements IEgarPerson {
	UUID uuid;
	String givenNames;
	String surname;
	EgarGender gender;
	Date dateOfBirth;
}
