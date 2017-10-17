package uk.gov.digital.ho.egar.services.v1.supportingdocs;

import java.util.UUID;

/**
 * Interface for any method signatures and constants will be used by the supporting docs object
 * @author Keshava.Grama
 *
 */
public interface SupportingDocs {

    UUID getUuid();
    /**
     * @see Amazon key management
     * @return
     */
    String getKeyReference();
}
