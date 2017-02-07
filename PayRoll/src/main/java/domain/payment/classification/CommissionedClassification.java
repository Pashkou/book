package domain.payment.classification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import customexceptions.SalesRecieptNotFoundException;
import domain.PaymentClassification;
import transaction.payments.Paycheck;

public class CommissionedClassification implements PaymentClassification {
	private List<SalesReciept> salesReciepts = new ArrayList<SalesReciept>();

	public void addSalesReciept(SalesReciept salesReciept){
		salesReciepts.add(salesReciept);
	}
	
	public SalesReciept getSalesReciept(LocalDate localDate){
		for(SalesReciept salesReciept: salesReciepts){
			if(salesReciept.getLocalDate().equals(localDate))
				return salesReciept;
		}
		throw new SalesRecieptNotFoundException();
	}

	
	public double calculatePay(Paycheck paycheck) {
		double result = 0;
		/*for(SalesReciept salesReciept: salesRecipts){
			salesReciept.getAmount();
			salesReciept.getDate();
			result += 0;
		}*/
		return result;
	}
}
