package com.retail.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
	private static List<Employee> employees = new ArrayList<Employee>();
	private static List<Employee> availableEmployees;

	static {
		employees.add(new Employee(987654, "Andrew", "Lance"));
		employees.add(new Employee(987655, "Susan", "Simpson"));
		employees.add(new Employee(987656, "Eric", "Gamma"));
		employees.add(new Employee(987657, "William", "Jobs"));
		
		employees.get(3).setHours(42.5);
	}

	public static List<Employee> getAllEmployees() {
		return employees;
	}

	public static List<Employee> getAvailableEmployees() {
		
		for(Iterator<Employee> iter = employees.listIterator(); iter.hasNext();) {
			Employee emp = iter.next();
			if (emp.getHours() > 40) {
				iter.remove();
			}
		}
 
		return employees;
	}

}
