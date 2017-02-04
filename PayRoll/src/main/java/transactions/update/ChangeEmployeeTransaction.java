package transactions.update;

import database.PayrollDatabase;
import domain.Employee;
import transactions.Transaction;

public abstract class ChangeEmployeeTransaction implements Transaction {
	private Integer employeeId;
	
	public ChangeEmployeeTransaction(Integer employeeId) {
		this.employeeId = employeeId;
	}

	protected abstract void change(Employee employee);
	
	public void execute() {
		Employee employee = PayrollDatabase.getEmployee(employeeId);
		change(employee);
	}

}
