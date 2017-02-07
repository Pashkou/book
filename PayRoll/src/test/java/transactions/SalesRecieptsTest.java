package transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import customexceptions.InvalidOperationException;
import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;
import domain.payment.classification.CommissionedClassification;
import domain.payment.classification.SalesReciept;
import transactions.add.AddCommissionedEmployeeTransaction;
import transactions.add.AddHourlyEmployeeTransaction;

public class SalesRecieptsTest {

	@Test
	public void addSalesRecieptToCommissionedEmployee(){
		Integer employeeID = 6;
		AddCommissionedEmployeeTransaction employeeTransaction = new AddCommissionedEmployeeTransaction(employeeID, "Siarhei", "Work");
		employeeTransaction.execute();
		SalesRecieptTransaction salesRecieptTransaction = new SalesRecieptTransaction(LocalDate.now(), 100.0, employeeID);
		salesRecieptTransaction.execute();
		
		Employee employee = PayrollDatabase.getEmployee(employeeID);
		PaymentClassification paymentClassification = employee.getPaymentClassification();
		assertTrue(paymentClassification instanceof CommissionedClassification);
		CommissionedClassification cc = (CommissionedClassification)paymentClassification;
		SalesReciept salesReciept = cc.getSalesReciept(LocalDate.now());
		assertEquals(salesReciept.getAmount(), 100.0, 0.001);
	}

	@Test(expected = InvalidOperationException.class)
	public void addSalesRecieptToNonExistingEmployee(){
		Integer employeeID = 6;
		SalesRecieptTransaction salesRecieptTransaction = new SalesRecieptTransaction(LocalDate.now(), 100.0, employeeID);
		salesRecieptTransaction.execute();
	}
	
	@Test(expected = InvalidOperationException.class)
	public void addSalesRecieptToNonCommissionedEmployee(){
		Integer employeeID = 7;
		AddHourlyEmployeeTransaction employeeTransaction = new AddHourlyEmployeeTransaction(employeeID, "Siarhei", "Work", 15.95);
		employeeTransaction.execute();
		
		SalesRecieptTransaction salesRecieptTransaction = new SalesRecieptTransaction(LocalDate.now(), 100.0, employeeID);
		salesRecieptTransaction.execute();
	}
	
}
