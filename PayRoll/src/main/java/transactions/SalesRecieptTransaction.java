package transactions;

import java.time.LocalDate;

import customexceptions.InvalidOperationException;
import database.PayrollDatabase;
import domain.Employee;
import domain.payment.classification.CommissionedClassification;
import domain.payment.classification.SalesReciept;

public class SalesRecieptTransaction implements Transaction {
	private LocalDate localDate;
	private double amount;
	private Integer employeeID;
	
	
	public SalesRecieptTransaction(LocalDate localDate, double amount, Integer employeeID) {
		this.localDate = localDate;
		this.amount = amount;
		this.employeeID = employeeID;
	}

	public void execute() {
		Employee employee = PayrollDatabase.getEmployee(employeeID);
		if(employee != null){
			
			CommissionedClassification cc = (CommissionedClassification)employee.getPaymentClassification();
			if(cc != null)
				cc.addSalesReciept(new SalesReciept(localDate, amount));
			else
				throw new InvalidOperationException("Tried to add sales reciept to non-commissioned employee.");
		}else
			throw new InvalidOperationException("Employee not found.");
	}

}
