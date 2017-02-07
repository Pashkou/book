package domain;

import transaction.payments.Paycheck;

public interface PaymentClassification {
	public double calculatePay(Paycheck paycheck);
}
