package transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;
import domain.payment.classification.CommissionedClassification;
import domain.payment.classification.SalesReciept;
import transactions.add.AddCommissionedEmployeeTransaction;

public class SalesRecieptsTest {
	private Integer employeeID = 6;
	
	@Before
	public void setup(){
		AddCommissionedEmployeeTransaction employeeTransaction = new AddCommissionedEmployeeTransaction(employeeID, "Siarhei", "Work");
		employeeTransaction.execute();
	}

	@Test
	public void addSalesRecieptToCommissionedEmployee(){
		SalesRecieptTransaction salesRecieptTransaction = new SalesRecieptTransaction(LocalDate.now(), 100.0, employeeID);
		salesRecieptTransaction.execute();
		
		Employee employee = PayrollDatabase.getEmployee(employeeID);
		PaymentClassification paymentClassification = employee.getPaymentClassification();
		assertTrue(paymentClassification instanceof CommissionedClassification);
		CommissionedClassification cc = (CommissionedClassification)paymentClassification;
		SalesReciept salesReciept = cc.getSalesReciept(LocalDate.now());
		assertEquals(salesReciept.getAmount(), 100.0, 0.001);
	}

}
