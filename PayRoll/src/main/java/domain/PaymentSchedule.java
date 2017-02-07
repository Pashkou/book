package domain;

import java.time.LocalDate;

public interface PaymentSchedule {
	public boolean isPayDate(LocalDate localDate);
}
