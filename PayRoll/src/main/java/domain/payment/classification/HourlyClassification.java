package domain.payment.classification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import customexceptions.TimeCardNotFoundException;
import domain.PaymentClassification;

public class HourlyClassification implements PaymentClassification {
	private List<TimeCard> timeCards = new ArrayList<TimeCard>();

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

	public double calculatePay() {
		double result = 0;
		/*for(TimeCard timeCard: timeCards){
			double hours = timeCard.getHours();
			Date date = timeCard.getDate();
			result += 0;
		}*/
		return result;
	}
}
