package uk.gov.digital.ho.egar.services.v1.gar;

import uk.gov.digital.ho.egar.services.v1.supportingdocs.SupportingDocs;

public interface SupportingDocsSnapShot extends SupportingDocs{
	String getBase64EncodedBinaryDoc();
}
