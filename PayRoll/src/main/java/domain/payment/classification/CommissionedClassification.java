package domain.payment.classification;

import java.util.List;

import domain.PaymentClassification;

public class CommissionedClassification implements PaymentClassification {
	private List<SalesReciept> salesRecipts;

	public double calculatePay() {
		double result = 0;
		for(SalesReciept salesReciept: salesRecipts){
			salesReciept.getAmount();
			salesReciept.getDate();
			result += 0;
		}
		return result;
	}
}
