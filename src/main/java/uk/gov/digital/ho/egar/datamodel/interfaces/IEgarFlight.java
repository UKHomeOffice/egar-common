package uk.gov.digital.ho.egar.datamodel.interfaces;

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
}
