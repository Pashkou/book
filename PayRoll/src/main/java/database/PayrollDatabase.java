package database;

import java.util.Hashtable;

import domain.Employee;

public class PayrollDatabase {
	private static Hashtable<Integer, Employee> employees = new Hashtable<Integer, Employee>();

	public static void AddEmployee(Integer id, Employee employee) {
		employees.put(id, employee);
	}

	public static Employee GetEmployee(Integer id)    {
		return employees.get(id);
	}
}
