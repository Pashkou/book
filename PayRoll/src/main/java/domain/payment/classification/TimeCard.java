package domain.payment.classification;

import java.time.LocalDate;

public class TimeCard {
	private LocalDate localDate;
	private double hours;
	
	public TimeCard(LocalDate localDate, double hours) {
		this.localDate = localDate;
		this.hours = hours;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public double getHours() {
		return hours;
	}
	
	
	
}
