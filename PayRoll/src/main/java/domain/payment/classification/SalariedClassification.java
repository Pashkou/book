package domain.payment.classification;

import domain.PaymentClassification;
import transaction.payments.Paycheck;

public class SalariedClassification implements PaymentClassification {
	private double salary;
	
	public SalariedClassification(double salary) {
		super();
		this.salary = salary;
	}

	public double calculatePay(Paycheck paycheck) {
		return salary;
	}

	public double getSalary() {
		return salary;
	}

}
