package com.retail.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

public class EmployeesTest {

	private List<Employee> availableEmpList;
	
	

	@Test
	public void testWith3AvailableEmployees() {
		availableEmpList = Employees.getAvailableEmployees();
		assertEquals(3,availableEmpList.size());
		assertFalse(availableEmpList.toString().contains("William"));
		
	}

}
