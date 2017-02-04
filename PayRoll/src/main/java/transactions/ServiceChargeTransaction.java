package transactions;

import java.time.LocalDate;

import database.PayrollDatabase;
import domain.Employee;
import domain.affiliation.ServiceCharge;
import domain.affiliation.UnionAffiliation;

public class ServiceChargeTransaction implements Transaction{
	private Integer memberId;
	private LocalDate localDate;
	private double amount;
	
	public ServiceChargeTransaction(Integer memberId, LocalDate localDate, double d) {
		this.memberId = memberId;
		this.localDate = localDate;
		amount = d;
	}

	public void execute() {
		Employee employee = PayrollDatabase.getUnionMember(memberId);
		UnionAffiliation affiliation = (UnionAffiliation)employee.getAffiliation();
		affiliation.addServiceCharge(localDate, new ServiceCharge(localDate, amount));
	}

}
