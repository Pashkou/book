package transaction.payments;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import transactions.add.AddSalariedEmployeeTransaction;

public class PaySalariedEmployeesTest {
	private Integer employeeID = 2;
	private String name = "Siarhei";
	private String address = "Home";
	
	
	@Before
	public void setup(){
		AddSalariedEmployeeTransaction ahet = new AddSalariedEmployeeTransaction(employeeID, name, address, 1000);
		ahet.execute();
	}
	
	@Test
	public void PaySingleSalariedEmployee(){
		LocalDate locatDate = LocalDate.of(2017, 1, 27);
		PaydayTransaction payTransytion = new PaydayTransaction(locatDate);
		payTransytion.execute();
		Paycheck pc = payTransytion.getPaycheck(employeeID);
		assertNotNull(pc);
		assertEquals(locatDate, pc.getPayDate());
		assertEquals(1000, pc.getGrossPay(), 0.001);
		assertEquals(1000, pc.getNetPay(), 0.001);
		assertEquals(0.0, pc.getDeductions(), 0.001);
		assertEquals("Hold", pc.getFiled("Disposition"));
	}
	
	@Test
	public void PaySingleSalariedEmployeeOnWrongDate(){
		LocalDate locatDate = LocalDate.of(2003, 1, 27);
		PaydayTransaction payTransytion = new PaydayTransaction(locatDate);
		payTransytion.execute();
		Paycheck pc = payTransytion.getPaycheck(employeeID);
		assertNull(pc);
	}
	
}
