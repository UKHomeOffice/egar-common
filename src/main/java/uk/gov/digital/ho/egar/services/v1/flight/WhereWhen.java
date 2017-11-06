package uk.gov.digital.ho.egar.services.v1.flight;

import java.time.LocalDateTime;

public interface WhereWhen {
	GeographicLocation getWhere();
	LocalDateTime getWhen(); 
}
