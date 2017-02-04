package transactions.update;

import database.PayrollDatabase;
import domain.Employee;

public class ChangeEmployeeAddressTransaction extends ChangeEmployeeTransaction{
	private String newAddress;
	private Integer employeeId;
	
	public ChangeEmployeeAddressTransaction(String newAddress, Integer employeeId) {
		super(employeeId);
		this.newAddress = newAddress;
		this.employeeId = employeeId;
	}

	@Override
	protected void change(Employee employee) {
		employee.setAddress(newAddress);
		PayrollDatabase.updateEmployee(employeeId, employee);
	}

}
