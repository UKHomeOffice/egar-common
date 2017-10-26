package uk.gov.digital.ho.egar.services.v1.people;


/**
 * Address contains all of the information pertaining to an address
 *
 * @author Keshava.Grama
 */
public interface Address {

    String getAddressLine1();

    String getAddressLine2();

    String getAddressLine3();

    String getAddressLine4();

    String getAddressLine5();

    String getPostCode();

}
