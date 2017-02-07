package transaction.payments;

import java.time.LocalDate;
import java.util.Enumeration;
import java.util.HashMap;

import database.PayrollDatabase;
import domain.Employee;
import transactions.Transaction;

public class PaydayTransaction implements Transaction  {
	private LocalDate localDate;
	private HashMap<Integer, Paycheck> paychecks = new HashMap<Integer, Paycheck>();
	
	private Enumeration<Integer> employeeIDs = PayrollDatabase.getEmployees().keys();
	
	public PaydayTransaction(LocalDate localDate) {
		this.localDate = localDate;
	}

	public void execute() {
		while(employeeIDs.hasMoreElements()){
			Integer employeeID = employeeIDs.nextElement();
			Employee employee = PayrollDatabase.getEmployee(employeeID);
			if(employee.isPayDate(localDate)){
				Paycheck pc = new Paycheck(localDate);
				employee.pay(pc);
				paychecks.put(employeeID, pc);
			}
		}
		
	}

	public Paycheck getPaycheck(Integer employeeID) {
		return paychecks.get(employeeID);
	}

}
