package transactions.add;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import domain.payment.classification.HourlyClassification;
import domain.payment.schedule.Weekly;

public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {

	public AddHourlyEmployeeTransaction(int employeeID, String name, String address) {
		super(employeeID, name, address);
	}

	@Override
	protected PaymentClassification MakeClassification() {
		return new HourlyClassification();
	}

	@Override
	protected PaymentSchedule MakeSchedule() {
		return new Weekly();
	}
}
