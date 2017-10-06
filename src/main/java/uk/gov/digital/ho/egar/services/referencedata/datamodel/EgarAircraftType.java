package uk.gov.digital.ho.egar.services.referencedata.datamodel;

import lombok.Data;
import uk.gov.digital.ho.egar.services.referencedata.IEgarAircraftType;
/**
 * Lookup field for aircraft types, this is system meta data DO NOT hard delete!
 * @author Keshava.Grama
 *
 */
@Data
public class EgarAircraftType implements IEgarAircraftType{
	String aircarftType;
}
