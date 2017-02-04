package transactions.update;

import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction{
	private Integer employeeId;
	
	public ChangeClassificationTransaction(Integer employeeId) {
		super(employeeId);
		this.employeeId = employeeId;
	}

	@Override
	protected void change(Employee employee) {
		PaymentClassification newPaymentClassification = initiateNewPaymentClassification();
		employee.setPaymentClassification(newPaymentClassification);
		PayrollDatabase.updateEmployee(employeeId, employee);
	}
	
	protected abstract PaymentClassification initiateNewPaymentClassification();
	
	

}
