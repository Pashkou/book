package transaction.payments;

import java.time.LocalDate;

public class Paycheck {
	
	private LocalDate localDate;
	private double grosspay;
	private double netpay;
	private double deductions;
	
	public double getDeductions() {
		return deductions;
	}

	public LocalDate getPayDate() {
		return localDate;
	}
	
	public double getGrossPay(){
		return grosspay;
	}

	public double getNetPay() {
		return netpay;
	}

	public String getFiled(String string) {
		return null;
	}

}
