package uk.gov.digital.ho.egar.services.v1.referencedata;

import java.util.List;

/**
 * Interface for any method signatures and constants that the country type lookup field will need
 * @author Keshava.Grama
 * @deprecated Will be removed in the next release.
 */
public interface Country {

    String getUuid();

    String getCountryName();

    List<String> getNationalities();

    String getIso3166CountryCode();
}
