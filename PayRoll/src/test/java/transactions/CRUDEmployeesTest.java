package transactions;

import static org.junit.Assert.*;

import org.junit.Test;

import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;
import domain.PaymentMethod;
import domain.PaymentSchedule;
import domain.payment.classification.CommissionedClassification;
import domain.payment.classification.HourlyClassification;
import domain.payment.classification.SalariedClassification;
import domain.payment.method.HoldMethod;
import domain.payment.schedule.Biweekly;
import domain.payment.schedule.Monthly;
import domain.payment.schedule.Weekly;

public class CRUDEmployeesTest {

	@Test
	public void testAddSalariedEmployee() {
		int empId = 1;
		AddSalariedEmployeeTransaction t = new AddSalariedEmployeeTransaction(new Integer(empId), "Bob", "Home",
				1000.00);
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertEquals("Bob", e.getName());
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof SalariedClassification);
		SalariedClassification sc = (SalariedClassification) pc;
		assertEquals(1000.00, sc.getSalary(), .001);
		PaymentSchedule ps = e.getPaymentSchedule();
		assertTrue(ps instanceof Monthly);
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);
	}

	@Test
	public void testAddHourlyEmployee() {
		int empId = 1;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(new Integer(empId), "Bob", "Home");
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertEquals("Bob", e.getName());
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);
		PaymentSchedule ps = e.getPaymentSchedule();
		assertTrue(ps instanceof Weekly);
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);
	}
	
	@Test
	public void testAddCommissionedEmployee() {
		int empId = 1;
		AddCommissionedEmployeeTransaction t = new AddCommissionedEmployeeTransaction(new Integer(empId), "Bob", "Home");
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertEquals("Bob", e.getName());
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof CommissionedClassification);
		PaymentSchedule ps = e.getPaymentSchedule();
		assertTrue(ps instanceof Biweekly);
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);
	}

	@Test
	public void DeleteEmployee() {
		int empId = 4;
		AddCommissionedEmployeeTransaction t = new AddCommissionedEmployeeTransaction(empId, "Bill", "Home");
		t.execute();
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNotNull(e);
		DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
		dt.execute();
		e = PayrollDatabase.getEmployee(empId);
		assertNull(e);
	}

}
