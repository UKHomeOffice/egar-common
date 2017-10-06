package uk.gov.digital.ho.egar.datamodel.objects;

import java.util.UUID;

import lombok.Data;

/**
 * EgarUKAddress stores the UK address for travellers, crew and captains.  
 * @author Keshava.Grama
 *
 */
@Data
public class EgarUKAddress {
	UUID idTraveller;
	int id;
	String addressLine1, addressLine2, addressLine3;
	String county;
	String postCode;
}
