package domain;

import java.util.List;

public class Employee {
	private PaymentMethod paymentMethod;
	private PaymentClassification paymentClassification;
	private List<Affiliation> affiliation;
	private PaymentSchedule paymentSchedule;
	
	private double employeeID;
	private String name;
	private String address;
	
	public Employee(double employeeID, String name, String address){
		this.employeeID = employeeID;
		this.name = name;
		this.address = address;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentClassification getPaymentClassification() {
		return paymentClassification;
	}

	public void setPaymentClassification(PaymentClassification paymentClassification) {
		this.paymentClassification = paymentClassification;
	}

	public PaymentSchedule getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}
	
}
