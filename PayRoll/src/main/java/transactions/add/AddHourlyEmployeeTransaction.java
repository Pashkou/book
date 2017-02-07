package transactions.add;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import domain.payment.classification.HourlyClassification;
import domain.payment.schedule.Weekly;

public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {

	private double horlyRate;
	public AddHourlyEmployeeTransaction(int employeeID, String name, String address, double horlyRate) {
		super(employeeID, name, address);
		this.horlyRate = horlyRate;
	}

	@Override
	protected PaymentClassification MakeClassification() {
		return new HourlyClassification(horlyRate);
	}

	@Override
	protected PaymentSchedule MakeSchedule() {
		return new Weekly();
	}
}
