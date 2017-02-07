package domain.payment.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

import domain.PaymentSchedule;

public class Weekly implements PaymentSchedule {
	public boolean isPayDate(LocalDate localDate) {
		return (localDate.getDayOfWeek() == DayOfWeek.FRIDAY);
	}
}
