package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.UUID;

import lombok.Data;

/**
 * EgarAddress is the basic   
 * @author Keshava.Grama
 *
 */
@Data
public abstract class EgarAddress {
	UUID idTraveller;
	int id;
	String addressLine1, addressLine2, addressLine3, addressLine4, addressLine5;
	String postCode;
}
