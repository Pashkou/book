package transaction.payments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import transactions.TimeCardTransaction;
import transactions.add.AddHourlyEmployeeTransaction;

public class PayHourlyEmployeeTest {
	private Paycheck payCheck;
	private LocalDate payDate;
	private int employeeID;

	@Before
	public void setup(){
		employeeID = 2;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(employeeID, "Bill", "Home", 15.25);
		t.execute();
		payDate = LocalDate.of(2017, 2, 10);
	}
	
	@Test
	public void payingSingleHourlyEmployeeNoTimeCards(){
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
		payCheck = pt.getPaycheck(employeeID);
		validatePayCheck(0, 0, 0);		
	}
	
	@Test
	public void paySingleHourlyEmployeeOneTimeCard(){
		TimeCardTransaction tct = new TimeCardTransaction(LocalDate.of(2017, 2, 6), 8, employeeID);
		tct.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
		payCheck = pt.getPaycheck(employeeID);
		validatePayCheck(122, 122, 0);	
	}
	
	private void validatePayCheck(double grossPay, double netPay, double deductions){
		assertNotNull(payCheck);
		assertEquals(payDate, payCheck.getPayDate());
		assertEquals(grossPay, payCheck.getGrossPay(), 0.01);
		assertEquals(netPay, payCheck.getNetpay(), 0.01);
		assertEquals(deductions, payCheck.getDeductions(), 0.01);
	}
}
