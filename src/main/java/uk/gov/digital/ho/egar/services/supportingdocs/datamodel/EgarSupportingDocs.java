package uk.gov.digital.ho.egar.services.supportingdocs.datamodel;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uk.gov.digital.ho.egar.datamodel.objects.EgarPersistedRecords;

/**
 * This is the container/descriptor object for binary files stored in S3 buckets. 
 * !!Important!!
 * Ideally the contents of the S3 bucket will be encrypted as they are sensitive. Leaky S3 buckets are a known 
 * weakness.
 * Choice of client/server side encryption waiting on homeoffice signoff.
 * 
 * @author Keshava.Grama
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EgarSupportingDocs extends EgarPersistedRecords {
	UUID uuid;
	String keyReference;
}
