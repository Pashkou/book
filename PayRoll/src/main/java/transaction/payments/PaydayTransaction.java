package transaction.payments;

import java.time.LocalDate;

import transactions.Transaction;

public class PaydayTransaction implements Transaction  {
	private LocalDate localDate;
	private Paycheck paycheck;
	
	public PaydayTransaction(LocalDate locatDate) {
		this.localDate = locatDate;
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public Paycheck getPaycheck(Integer employee) {
		return paycheck;
	}

}
