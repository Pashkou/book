package transactions.update;

import domain.Affiliation;
import domain.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction  {

	public ChangeAffiliationTransaction(Integer employeeId) {
		super(employeeId);
	}

	@Override
	protected void change(Employee employee) {
		recordMembership(employee);
		employee.setAffiliation(getAffiliation());
	}

	protected abstract void recordMembership(Employee employee);
	protected abstract Affiliation getAffiliation();
	
}
