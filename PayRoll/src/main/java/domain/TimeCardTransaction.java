package domain;

import java.time.LocalDate;

import database.PayrollDatabase;
import domain.payment.classification.HourlyClassification;
import domain.payment.classification.TimeCard;
import transactions.Transaction;

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
		TimeCard timeCard = new TimeCard(localDate, hours);
		HourlyClassification hc = (HourlyClassification)employee.getPaymentClassification();
		hc.addTimeCard(timeCard);
	}
	
}
