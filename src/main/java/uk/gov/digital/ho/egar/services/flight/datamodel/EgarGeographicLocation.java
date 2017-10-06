package uk.gov.digital.ho.egar.services.flight.datamodel;

import uk.gov.digital.ho.egar.services.flight.IEgarFlight;
import uk.gov.digital.ho.egar.services.referencedata.datamodel.EgarIATACode;
import uk.gov.digital.ho.egar.services.referencedata.datamodel.EgarICAOCode;
/**
 * Origin and destination records for a GAR not persisted independently
 * @author Keshava.Grama
 *
 */
public class EgarGeographicLocation implements IEgarFlight.IEgarGeographicLocation{
	EgarICAOCode icaoCode;
	EgarIATACode iataCode;
	String latitude;
	String longitude;
	String postcode;
	String freeTextLocation;
	String via;
	
	public boolean validateGeographicLocation() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
