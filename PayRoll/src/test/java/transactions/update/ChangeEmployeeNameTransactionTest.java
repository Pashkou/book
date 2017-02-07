package transactions.update;

import static org.junit.Assert.*;

import org.junit.Test;

import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;
import domain.PaymentMethod;
import domain.PaymentSchedule;
import domain.payment.classification.HourlyClassification;
import domain.payment.method.HoldMethod;
import domain.payment.schedule.Weekly;
import transactions.add.AddHourlyEmployeeTransaction;

public class ChangeEmployeeNameTransactionTest {

	private final String oldName = "Bob";
	private final String newName = "Bill";
	
	@Test
	public void testChangeNameEmployee() {
		Integer empId = 1;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, oldName , "Home", 15.95);
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertEquals("Bob", e.getName());
		
		ChangeEmployeeNameTransaction changeEmployeeNameTransaction = new ChangeEmployeeNameTransaction(empId, newName);
		changeEmployeeNameTransaction.execute();
		
		e = PayrollDatabase.getEmployee(empId);
		assertEquals(newName, e.getName());
	}

}
