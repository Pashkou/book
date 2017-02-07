package transactions.update;

import org.junit.Test;

import database.PayrollDatabase;
import domain.Affiliation;
import domain.Employee;
import transactions.add.AddHourlyEmployeeTransaction;

public class ChangeUnionMemberTest {
	
	@Test
	public void testChangeUnionMembership(){
		Integer employeeID = 9;
		AddHourlyEmployeeTransaction ahet = new AddHourlyEmployeeTransaction(employeeID, "name", "address", 15.95);
		ahet.execute();
		
		Employee employee = PayrollDatabase.getEmployee(employeeID);
		Affiliation aff = employee.getAffiliation();
		
		Integer memberID = 10;
		ChangeUnionMemberTransaction cumt = new ChangeUnionMemberTransaction(employeeID, memberID, 99.42);
		cumt.execute();
		
		
	}
	
}
