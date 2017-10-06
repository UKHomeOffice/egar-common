package uk.gov.digital.ho.egar.services.flight;

/**
 * Interface for any method signatures and constants that the are relevant to a flight
 * @author Keshava.Grama
 *
 */
public interface IEgarFlight {
	public enum EgarReasonForFlight{
		shortterm,
		repair,
		aircraftimport
	};
	
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

}
