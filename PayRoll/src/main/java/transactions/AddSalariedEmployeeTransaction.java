package transactions;

import domain.PaymentClassification;
import domain.PaymentSchedule;
import domain.payment.classification.SalariedClassification;
import domain.payment.schedule.Monthly;

public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction {
	private double salary;
	
	public AddSalariedEmployeeTransaction(int employeeID, String name, String address, double salary) {
		super(employeeID, name, address);
		this.salary = salary;
	}

	@Override
	protected PaymentClassification MakeClassification() {
		return new SalariedClassification(salary);
	}

	@Override
	protected PaymentSchedule MakeSchedule() {
		return new Monthly();
	}

}
