package transactions.update;

import database.PayrollDatabase;
import domain.Affiliation;
import domain.Employee;
import domain.affiliation.UnionAffiliation;

public class ChangeUnionMemberTransaction extends ChangeAffiliationTransaction{
	private Integer memberId;
	private double dues;
	
	public ChangeUnionMemberTransaction(Integer employeeId, Integer memberId, double dues) {
		super(employeeId);
		this.memberId = memberId;
		this.dues = dues;
	}

	@Override
	protected void recordMembership(Employee employee) {
		PayrollDatabase.AddUnionMember(memberId, employee);
	}

	@Override
	protected Affiliation getAffiliation() {
		return new UnionAffiliation(memberId, dues);
	}

}
