package uk.gov.digital.ho.egar.services.people;

/**
 * Interface for any method signatures and constants are related to travellers in a GAR
 * @author Keshava.Grama
 *
 */
public interface IEgarTraveller{
	public enum EgarDocumentType{
		passport,
		identitycard,
		other
	};
	
	public enum EgarTravellerType{
		captain,
		crew,
		passanger
	};
}
