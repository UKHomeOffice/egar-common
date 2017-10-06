package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.Date;
import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarTraveller.EgarDocumentType;
import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarTraveller.EgarTravellerType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * EgarTraveller extends on EgarPerson and adds persists additional information about a 
 * person such as passport, nationality, travel doc etc. This information could potentially change
 * between journeys
 * @author Keshava.Grama
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EgarTraveller extends EgarPerson {
	UUID id;
	EgarUKAddress ukAddress;
	String nationality;
	Date travelDocumentExipiryDate;
	String travelDocumentIssuingCountry;
	String travelDocumentNumber;
	EgarDocumentType documentType;
	EgarTravellerType travellerType;
}
