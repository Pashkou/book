package database;

import java.util.Hashtable;

import domain.Employee;

public class PayrollDatabase {
	private static Hashtable<Integer, Employee> employees = new Hashtable<Integer, Employee>();
	private static Hashtable<Integer, Employee> unionMembers = new Hashtable<Integer, Employee>();

	public static void AddEmployee(Integer id, Employee employee) {
		employees.put(id, employee);
	}

	public static Employee getEmployee(Integer id)    {
		return employees.get(id);
	}
	
	public static Employee getUnionMember(Integer id)    {
		return unionMembers.get(id);
	}

	public static void removeEmployee(Integer empId) {
		employees.remove(empId);
	}

	public static void AddUnionMember(Integer memberId, Employee employee) {
		unionMembers.put(memberId, employee);		
	}
}
