package transactions.update;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;
import domain.payment.classification.CommissionedClassification;
import domain.payment.classification.HourlyClassification;
import transactions.add.AddCommissionedEmployeeTransaction;

public class ChangeHourlyClassificationTransactionTest {

	@Test
	public void testChangeClassificationOfEmployee(){
		Integer empId = 1;
		AddCommissionedEmployeeTransaction t = new AddCommissionedEmployeeTransaction(empId, "Bob", "Home");
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof CommissionedClassification);
		
		ChangeHourlyClassificationTransaction chct = new ChangeHourlyClassificationTransaction(empId);
		chct.execute();

		e = PayrollDatabase.getEmployee(empId);
		pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);
	}

}
