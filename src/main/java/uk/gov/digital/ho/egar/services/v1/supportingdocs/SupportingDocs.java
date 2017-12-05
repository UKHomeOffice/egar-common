package uk.gov.digital.ho.egar.services.v1.supportingdocs;

import java.util.UUID;

import uk.gov.digital.ho.egar.datamodel.PersistedRecord;

/**
 * Interface for any method signatures and constants will be used by the supporting docs object
 * @author Keshava.Grama
 * @deprecated Will be removed in the next release.
 */
public interface SupportingDocs extends PersistedRecord{

    UUID getUuid();
    /**
     * @see Amazon key management
     * @return
     */
    String getKeyReference();
}
