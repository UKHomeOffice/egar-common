package uk.gov.digital.ho.egar.services.v1.flight;

import java.time.LocalDate;
import java.time.LocalTime;

public interface WhereWhen {
	GeographicLocation getWhere();
	LocalDate getWhen();
	LocalTime getTimeOfDay();
}
