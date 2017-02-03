package domain.payment.classification;

import java.time.LocalDate;

public class SalesReciept {
	
	private double amount;
	private LocalDate localDate;

	public SalesReciept(LocalDate localDate, double amount) {
		this.localDate = localDate;
		this.amount = amount;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
