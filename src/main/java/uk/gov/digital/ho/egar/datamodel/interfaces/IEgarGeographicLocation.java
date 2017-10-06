package uk.gov.digital.ho.egar.datamodel.interfaces;

/**
 * Interface for any method signatures and constants that geographic location (from/to) field for a flight
 * @author Keshava.Grama
 *
 */
public interface IEgarGeographicLocation {
	/**
	 * 
	 * @return true when one of the geographic indicators is populated
	 */
	public boolean validateGeographicLocation();
}
