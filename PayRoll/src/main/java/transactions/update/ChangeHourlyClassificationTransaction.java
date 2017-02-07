package transactions.update;

import domain.PaymentClassification;
import domain.payment.classification.HourlyClassification;

public class ChangeHourlyClassificationTransaction extends ChangeClassificationTransaction {

	public ChangeHourlyClassificationTransaction(Integer employeeId) {
		super(employeeId);
	}

	@Override
	protected PaymentClassification initiateNewPaymentClassification() {
		return new HourlyClassification(0);
	}

}
