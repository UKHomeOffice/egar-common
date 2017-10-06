package uk.gov.digital.ho.egar.datamodel.objects;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarGeographicLocation;
import uk.gov.digital.ho.egar.datamodel.lookup.objects.EgarIATACode;
import uk.gov.digital.ho.egar.datamodel.lookup.objects.EgarICAOCode;
/**
 * Origin and destination records for a GAR not persisted independently
 * @author Keshava.Grama
 *
 */
public class EgarGeographicLocation implements IEgarGeographicLocation{
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
