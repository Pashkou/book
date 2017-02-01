package domain.payment.classification;

import java.util.Date;
import java.util.List;

import domain.PaymentClassification;

public class HourlyClassification implements PaymentClassification {
	private List<TimeCard> timeCards;

	public double calculatePay() {
		double result = 0;
		for(TimeCard timeCard: timeCards){
			double hours = timeCard.getHours();
			Date date = timeCard.getDate();
			result += 0;
		}
		return result;
	}
}
