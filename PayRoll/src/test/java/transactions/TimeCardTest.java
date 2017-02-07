package transactions;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;
import database.PayrollDatabase;
import domain.Employee;
import domain.PaymentClassification;
import domain.payment.classification.HourlyClassification;
import domain.payment.classification.TimeCard;
import transactions.add.AddHourlyEmployeeTransaction;

public class TimeCardTest {

	@Test
	public void addTimeCardToHourlyEmployee(){
		Integer employeeID = 5;
		AddHourlyEmployeeTransaction employeeTransaction = new AddHourlyEmployeeTransaction(employeeID, "Siarhei", "Home", 15.95);
		employeeTransaction.execute();
		TimeCardTransaction timeCardTA = new TimeCardTransaction(LocalDate.now(), 8.0, employeeID);
		timeCardTA.execute();
		
		Employee employee = PayrollDatabase.getEmployee(employeeID);
		PaymentClassification paymentClassification = employee.getPaymentClassification();
		assertTrue(paymentClassification instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification)paymentClassification;
		TimeCard timeCard = hc.getTimeCard(LocalDate.now());
		assertEquals(timeCard.getHours(), 8.0, 0.001);
	}
}
