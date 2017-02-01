package domain.payment.classification;

import domain.PaymentClassification;

public class SalariedClassification implements PaymentClassification {
	private double salary;
	
	public SalariedClassification(double salary) {
		super();
		this.salary = salary;
	}

	public double calculatePay() {
		return salary;
	}

}
