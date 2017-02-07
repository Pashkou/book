package domain.payment.classification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import customexceptions.TimeCardNotFoundException;
import domain.PaymentClassification;
import transaction.payments.Paycheck;

public class HourlyClassification implements PaymentClassification {
	private List<TimeCard> timeCards = new ArrayList<TimeCard>();
	private double houryRare;
	
	public HourlyClassification(double houryRare){
		this.houryRare = houryRare;
	}
	
	public void addTimeCard(TimeCard timeCard){
		timeCards.add(timeCard);
	}
	
	public TimeCard getTimeCard(LocalDate localDate) throws TimeCardNotFoundException {
		for(TimeCard timeCard: timeCards){
			if(timeCard.getLocalDate().equals(localDate)){
				return timeCard;
			}
		}
		throw new TimeCardNotFoundException();
	}
	
	public double calculatePay(Paycheck paycheck) {
		double result = 0;
		for(TimeCard timeCard: timeCards){
			if( isInTimePeriod(paycheck, timeCard) ){
				double hours = timeCard.getHours();
				if(hours > 8){
					double overtime = Math.abs(hours - 8);
					result += overtime * houryRare * 1.5;
					hours = 8;
				}
				result += hours * houryRare;
			}
		}
		return result;
	}

	private boolean isInTimePeriod(Paycheck paycheck, TimeCard timeCard) {
		return paycheck.getPayDate().getDayOfYear() - timeCard.getLocalDate().getDayOfYear() < 6;
	}

}
