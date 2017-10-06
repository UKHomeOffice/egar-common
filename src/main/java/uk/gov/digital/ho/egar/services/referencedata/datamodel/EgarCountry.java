package uk.gov.digital.ho.egar.services.referencedata.datamodel;

import java.util.List;

import lombok.Data;
import uk.gov.digital.ho.egar.services.referencedata.IEgarCountry;

/**
 * Lookup field for countries and related nationalities, this is system meta data DO NOT hard delete!
 * @author Keshava.Grama
 *
 */
@Data
public class EgarCountry implements IEgarCountry {
	String uuid;
	String countryName;
	List<String> nationalities;
	String iso3166CountryCode;
}
