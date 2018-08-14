package com.retail.core;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




public class EmployeeTest {

	private Employee employee;
	
	@Before
	public void setUp() throws Exception {
		employee = new Employee(12345L, "James", "Craft");
	}

	@Test
	public void testConstructor() {
		assertEquals(12345L, employee.getEmpId());
		assertEquals("James", employee.getFirstName());
		assertEquals("Craft", employee.getLastName());
	}
	
	@Test
	public void testOver40Hours() {
		boolean isAvailable = false;
		employee.setHours(40.01);
		if(employee.getHours() < 40) {
			isAvailable = true;
		}
		
		assertFalse(isAvailable);
	}

	
	@Test
	public void testUnder40Hours() {
		boolean isAvailable = false;
		employee.setHours(0.0);
		if(employee.getHours() < 40) {
			isAvailable = true;
		}
		
		assertTrue(isAvailable);
	}

}
