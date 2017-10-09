package uk.gov.digital.ho.egar.services.v1.people;

import java.util.UUID;

/**
 * Address contains all of the information pertaining to an address
 *
 * @author Keshava.Grama
 */
public interface Address {

    UUID getIdTraveller();

    int getId();

    String getAddressLine1();

    String getAddressLine2();

    String getAddressLine3();

    String getAddressLine4();

    String getAddressLine5();

    String getPostCode();

}
