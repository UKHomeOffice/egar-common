package uk.gov.digital.ho.egar.services.v1.flight;

/**
 * Interface for any method signatures and constants that geographic location (from/to) field for a flight
 * @author Keshava.Grama
 * @deprecated Will be removed in the next release.
 *
 */
public interface GeographicLocation {

    String getIcaoCode();

    String getIataCode();

    String getLatitude();

    String getLongitude();

    String getPostcode();

    String getFreeTextLocation();

    String getVia();

    /**
     * Validates the geographic location.
     * @return true when one of the geographic indicators is populated
     */
    boolean validateGeographicLocation();
}
