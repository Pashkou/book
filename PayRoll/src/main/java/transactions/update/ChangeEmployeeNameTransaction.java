package transactions.update;

import database.PayrollDatabase;
import domain.Employee;

public class ChangeEmployeeNameTransaction extends ChangeEmployeeTransaction {
	private String newName;
	private Integer employeeId;
	
	public ChangeEmployeeNameTransaction(Integer employeeId, String newName) {
		super(employeeId);
		this.newName = newName;
		this.employeeId = employeeId;
	}

	@Override
	protected void change(Employee employee) {
		employee.setName(newName);
		PayrollDatabase.updateEmployee(employeeId, employee);
	}

}
