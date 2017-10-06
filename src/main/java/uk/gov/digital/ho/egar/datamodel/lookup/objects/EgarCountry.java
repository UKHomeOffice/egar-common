package uk.gov.digital.ho.egar.datamodel.lookup.objects;

import java.util.List;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarCountry;

import lombok.Data;

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
