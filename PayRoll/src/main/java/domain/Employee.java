package domain;

import java.time.LocalDate;

import domain.affiliation.NoAffiliation;
import transaction.payments.Paycheck;

public class Employee {
	private PaymentMethod paymentMethod;
	private PaymentClassification paymentClassification;
	private Affiliation affiliation = new NoAffiliation();
	private PaymentSchedule paymentSchedule;
	
	private double employeeID;
	private String name;
	private String address;
	
	public Employee(double employeeID, String name, String address){
		this.employeeID = employeeID;
		this.name = name;
		this.address = address;
	}

	public boolean isPayDate(LocalDate localDate){
		return paymentSchedule.isPayDate(localDate);
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

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}

	public Affiliation getAffiliation() {
		return affiliation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String newAddress) {
		this.address = newAddress;
	}

	public void pay(Paycheck pc) {
		double grossPay = paymentClassification.calculatePay();
		double deductions = affiliation.calculateDeductions(pc);
		pc.setDeductions(deductions);
		pc.setGrosspay(grossPay);
		double netPay = grossPay - deductions;
		pc.setNetpay(netPay);
		pc.setDeductions(deductions);
	}
}
