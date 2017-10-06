package uk.gov.digital.ho.egar.datamodel.interfaces;

/**
 * Parent interface for all persisted records in the database. It will be used to automate the cleanup of records
 * @author Keshava.Grama
 *
 */
public interface IEgarPersistedRecord {
	public enum PurgePeriod{
		threeMonths,
		sixMonths,
		twelveMonths
	};

}
