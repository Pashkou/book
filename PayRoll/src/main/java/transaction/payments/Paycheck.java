package transaction.payments;

import java.time.LocalDate;

public class Paycheck {
	
	private LocalDate localDate;
	private double grosspay;
	private double netpay;
	private double deductions;
	
	public Paycheck(LocalDate localDate) {
		this.localDate = localDate;	
	}

	public double getNetpay() {
		return netpay;
	}

	public void setNetpay(double netpay) {
		this.netpay = netpay;
	}

	public double getDeductions() {
		return deductions;
	}

	public LocalDate getPayDate() {
		return localDate;
	}
	
	public double getGrossPay(){
		return grosspay;
	}

	public String getFiled(String string) {
		return null;
	}

	public void setGrosspay(double grosspay) {
		this.grosspay = grosspay;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

}
