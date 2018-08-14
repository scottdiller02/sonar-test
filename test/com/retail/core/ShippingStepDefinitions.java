package com.retail.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class ShippingStepDefinitions {
	private WebDriver driver;
	private long employeeIdentification;
	
	
	@Before("@Web2")
	public void setUp() {

		/*System.setProperty("webdriver.chrome.driver",
				"C:/Users/admin/SeleniumProjects/chromedriver_win32" + "/chromedriver.exe");
		driver = new ChromeDriver();*/
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files" + "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:882/SimpleRetailWeb_PracticeGradedLab2/ShippingServlet");
		
	}
	

	@Given("^These packages \"([^\"]*)\ are being shipped by \"([^\"]*)\"$")
	public void these_packages_are_being_shipped_by(String upcList, String employee) throws Throwable {
	    // Split upcList and store into a collection.... 
		// Accept value for employee first name and associate it with an employee ID
		String employeeLastName = "";
		
		String [] upcCodes = upcList.split(" ");
		
		for(int i=0; i<upcCodes.length; i++) {
			String checkTheBox = upcCodes[i];
			WebElement check = driver.findElement(By.xpath("//input[@value='"checkTheBox"']"));
			check.click();
		}
		
		//Find the employee you are looking for and record their last name and ID
		//There is definitely a better way to do this...... 
		for(Iterator<Employee> iter = Employees.getAvailableEmployees().listIterator(); iter.hasNext();) {
			Employee tempEmp = iter.next();
			String empName = tempEmp.getFirstName();
			if(employee.equalsIgnoreCase(empName)) {
				employeeIdentification = tempEmp.getEmpId();
				employeeLastName = tempEmp.getLastName();
			}
		}
		
		String employeeFullName = employee + " " + employeeLastName;
		//Select employee name from the dropdown 
		//This Select combines the driver.findElement() expression with the Select
		Select employeeSelect = new Select(driver.findElement(By.id("availableEmployees")));
		employeeSelect.selectByVisibleText(employeeFullName);
		
		 
	}

	@Given("^The shipping routes will be from \"([^\"]*)\" to \"([^\"]*)\" with (\\d+) distance$")
	public void the_shipping_route_will_be_from_to_with_distance(String fromCity, String toCity, int mileage) throws Throwable {
		//Reads in and selects the two cities, then reads in the distance and asserts the correct distance
		
		//This Select expression separately defines the WebElement and the creates a Select
	    WebElement fromList = driver.findElement(By.id("fromCities"));
	    Select fromSelect = new Select(fromList);
	    fromSelect.selectByVisibleText(fromCity);
	    
	    // Select the toCity from drop down menu
	    WebElement toList = driver.findElement(By.id("toCities"));
	    Select toSelect = new Select(toList);
	    toSelect.selectByVisibleText(toCity);
	    
	   // assert mileage between the two cities
	   int expectedMileage = mileage;
	   WebElement actualMileage = driver.findElement(By.id("miles"));
	   assertEquals(expectedMileage, Integer.parseInt(actualMileage.getText()));
	}
	
	@When("^The User Navigates to Create Shipment Page$")
	public void the_User_Navigates_to_Create_Shipment_Page() throws Throwable {
		//Clicks the "Create Shipment" button
		String xpathVal = "//input[@value='Create Shipment']";
		WebElement btn = driver.findElement(By.xpath(xpathVal));
		btn.submit();
		assertTrue( driver.getCurrentUrl().contains("ShippingServlet"));

	}

	@Then("^The employee number will be displayed$")
	public void the_employee_number_will_be_displayed() throws Throwable {
	    // Assert that the proper employee number is displayed (we defined employeeIdentification in the first @Given method)
		WebElement employeeId = driver.findElement(By.id("empId"));
		assertEquals(Long.parseLong(employeeId.getText()), employeeIdentification);
	    
	}

	@Then("^The total cost should be (\\d+)\\.(\\d+)$")
	public void the_total_cost_should_be(double totalDollars, double totalCents) throws Throwable {
	    // Assert that the total is correct
		double expectedTotalShip = totalDollars + (totalCents/100);
	    WebElement total = driver.findElement(By.id("totalCost"));
	    double actualTotal = Double.parseDouble(total.getText());
	    assertEquals(actualTotal,expectedTotalShip, .01);
	}
	
	
	@After("@Web0")
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
