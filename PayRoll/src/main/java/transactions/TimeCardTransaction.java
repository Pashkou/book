package transactions;

import java.time.LocalDate;

import customexceptions.InvalidOperationException;
import database.PayrollDatabase;
import domain.Employee;
import domain.payment.classification.HourlyClassification;
import domain.payment.classification.TimeCard;

public class TimeCardTransaction implements Transaction{
	private LocalDate localDate;
	private double hours;
	private Integer employeeID;
	
	
	public TimeCardTransaction(LocalDate localDate, double hours, Integer employeeID) {
		this.localDate = localDate;
		this.hours = hours;
		this.employeeID = employeeID;
	}

	public void execute() {
		Employee employee = PayrollDatabase.getEmployee(employeeID);
		if(employee != null){
			HourlyClassification hc = (HourlyClassification)employee.getPaymentClassification();
			TimeCard timeCard = new TimeCard(localDate, hours);
			
			if(hc != null)
				hc.addTimeCard(timeCard);
			else
				throw new InvalidOperationException("Tried added timecard to non-hour employee.");
			
		} else
			throw new InvalidOperationException("No such employee");
	}
	
}
