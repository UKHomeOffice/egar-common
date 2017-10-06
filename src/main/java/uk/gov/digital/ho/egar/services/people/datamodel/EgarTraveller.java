package uk.gov.digital.ho.egar.services.people.datamodel;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uk.gov.digital.ho.egar.datamodel.objects.EgarAddress;
import uk.gov.digital.ho.egar.services.people.IEgarTraveller;

/**
 * EgarTraveller extends on EgarPerson and adds persists additional information about a 
 * person such as passport, nationality, travel doc etc. This information could potentially change
 * between journeys
 * @author Keshava.Grama
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EgarTraveller extends EgarPerson implements IEgarTraveller{
	UUID id;
	EgarAddress ukAddress;
	String nationality;
	Date travelDocumentExipiryDate;
	String travelDocumentIssuingCountry;
	String travelDocumentNumber;
	EgarDocumentType documentType;
	EgarTravellerType travellerType;
}
