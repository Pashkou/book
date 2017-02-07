package domain;

import transaction.payments.Paycheck;

public interface Affiliation {
	public double calculateDeductions(Paycheck payCheck);
}
