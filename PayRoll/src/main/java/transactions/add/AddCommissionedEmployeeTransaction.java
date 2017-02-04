package transactions.add;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import domain.payment.classification.CommissionedClassification;
import domain.payment.schedule.Biweekly;

public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction{

	public AddCommissionedEmployeeTransaction(int employeeID, String name, String address) {
		super(employeeID, name, address);
	}

	@Override
	protected PaymentClassification MakeClassification() {
		return new CommissionedClassification();
	}

	@Override
	protected PaymentSchedule MakeSchedule() {
		return new Biweekly();
	}

}
