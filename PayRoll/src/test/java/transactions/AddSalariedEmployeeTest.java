package transactions;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddSalariedEmployeeTest {

	@Test
	public void testAddSalariedEmployee() {
		int empId = 1;
		AddSalariedEmployeeTransaction t = new AddSalariedEmployeeTransaction(new Integer(empId), "Bob", "Home", 1000.00); 
		t.execute();
		/*Employee e = PayrollDatabase.GetEmployee(empId);
		Assert.AreEqual("Bob", e.Name);
		PaymentClassification pc = e.Classification;
		Assert.IsTrue(pc is SalariedClassification);
		SalariedClassification sc = pc as SalariedClassification;
		Assert.AreEqual(1000.00, sc.Salary, .001);
		PaymentSchedule ps = e.Schedule;
		Assert.IsTrue(ps is MonthlySchedule);
		PaymentMethod pm = e.Method; 
		Assert.IsTrue(pm is HoldMethod); */
	}

}
