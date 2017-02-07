package domain.payment.schedule;

import java.time.LocalDate;

import domain.PaymentSchedule;

public class Monthly implements PaymentSchedule {

	public boolean isPayDate(LocalDate localDate) {
		LocalDate nextDate = localDate.plusDays(1);
		return (!nextDate.getMonth().equals(localDate.getMonth()));
	}

}
