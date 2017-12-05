package uk.gov.digital.ho.egar.services.v1.flight;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @deprecated Will be removed in the next release.
 */
public interface WhereWhen {
	GeographicLocation getWhere();
	LocalDate getWhen();
	LocalTime getTimeOfDay();
}
