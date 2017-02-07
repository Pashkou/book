package domain.affiliation;

import domain.Affiliation;
import transaction.payments.Paycheck;

public class NoAffiliation implements Affiliation {

	public double calculateDeductions(Paycheck payCheck) {
		return 0;
	}

}
