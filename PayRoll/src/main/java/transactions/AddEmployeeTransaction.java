package transactions;

import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;
import domain.PaymentMethod;
import domain.PaymentSchedule;
import domain.payment.method.HoldMethod;

public abstract class AddEmployeeTransaction implements Transaction {

	private int employeeID;
	private String name;
	private String address;

	public AddEmployeeTransaction(int employeeID, String name, String address) {
		this.employeeID = employeeID;
		this.name = name;
		this.address = address;
	}

	protected abstract PaymentClassification MakeClassification();

	protected abstract PaymentSchedule MakeSchedule();

	public void execute() {
		PaymentClassification pc = MakeClassification();
		PaymentSchedule ps = MakeSchedule();
		
		PaymentMethod pm = new HoldMethod();
		Employee employee = new Employee(employeeID, name, address);
		employee.setPaymentClassification(pc);
		employee.setPaymentSchedule(ps);
		employee.setPaymentMethod(pm);
		
		PayrollDatabase.AddEmployee(new Integer(employeeID), employee);
	}

}
