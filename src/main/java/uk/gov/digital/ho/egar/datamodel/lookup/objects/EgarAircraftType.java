package uk.gov.digital.ho.egar.datamodel.lookup.objects;

import uk.gov.digital.ho.egar.datamodel.interfaces.IEgarAircraftType;

import lombok.Data;
/**
 * Lookup field for aircraft types, this is system meta data DO NOT hard delete!
 * @author Keshava.Grama
 *
 */
@Data
public class EgarAircraftType implements IEgarAircraftType{
	String aircarftType;
}
