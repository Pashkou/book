package transactions;

import database.PayrollDatabase;

public class DeleteEmployeeTransaction  implements Transaction{
	private int empId;
	
	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
	}

	public void execute() {
		PayrollDatabase.removeEmployee(empId);
	}
}
