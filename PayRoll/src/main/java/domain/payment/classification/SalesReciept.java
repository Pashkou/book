package domain.payment.classification;

import java.util.Date;

public class SalesReciept {
	private double amount;
	private Date date;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
