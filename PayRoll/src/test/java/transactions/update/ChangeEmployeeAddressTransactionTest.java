package transactions.update;

import static org.junit.Assert.*;

import org.junit.Test;

import database.PayrollDatabase;
import domain.Employee;
import transactions.add.AddHourlyEmployeeTransaction;

public class ChangeEmployeeAddressTransactionTest {

	
	@Test
	public void testChangeNameEmployee() {
		Integer empId = 1;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Name" , "Home", 15.95);
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertEquals("Home", e.getAddress());
		
		ChangeEmployeeAddressTransaction changeEmployeeAddressTransaction = new ChangeEmployeeAddressTransaction("new home", empId);
		changeEmployeeAddressTransaction.execute();
		
		e = PayrollDatabase.getEmployee(empId);
		assertEquals("new home", e.getAddress());
	}

}
