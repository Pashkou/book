package domain.affiliation;

import java.time.LocalDate;

public class ServiceCharge {
	
	private LocalDate localDate;
	private double amount;
	
	public ServiceCharge(LocalDate localDate, double amount) {
		this.localDate = localDate;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
