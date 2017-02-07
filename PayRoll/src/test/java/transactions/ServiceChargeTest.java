package transactions;

import static org.junit.Assert.*;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;
import database.PayrollDatabase;
import domain.Employee;
import domain.affiliation.ServiceCharge;
import domain.affiliation.UnionAffiliation;
import transactions.add.AddHourlyEmployeeTransaction;

public class ServiceChargeTest {

	@Test
	public void addServiceCharge(){
		Integer employeeId = 7;
		AddHourlyEmployeeTransaction addHempTC = new AddHourlyEmployeeTransaction(employeeId, "Pashkou", "Sweet home", 15.95);
		addHempTC.execute();
		
		Employee employee = PayrollDatabase.getEmployee(employeeId);
		assertNotNull(employee);
		
		UnionAffiliation af = new UnionAffiliation();
		employee.setAffiliation(af);
		
		Integer memberId = 86; // Maxwell Smart
		PayrollDatabase.AddUnionMember(memberId, employee);
		
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, LocalDate.now(), 12.95);
		sct.execute();
		
		ServiceCharge sc = af.getServiceCharge(LocalDate.now());
		assertNotNull(sc);
		assertEquals(12.95, sc.getAmount(), 0.001);
	}

}
