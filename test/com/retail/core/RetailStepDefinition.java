package com.retail.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class RetailStepDefinition {

	private WebDriver driver;
	private Map<String, String> upcToPriceMap;

	@Before("@Web")
	public void setUp() {

		/*System.setProperty("webdriver.chrome.driver",
				"C:/Users/admin/SeleniumProjects/chromedriver_win32" + "/chromedriver.exe");
		driver = new ChromeDriver();*/
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files" + "/chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@Given("^the following Data:$")
	public void the_following_Data(DataTable upcPriceTable) throws Throwable {

		upcToPriceMap = new HashMap<String, String>();
		for (DataTableRow row : upcPriceTable.getGherkinRows()) {
			upcToPriceMap.put(row.getCells().get(0), row.getCells().get(1));
		}

		assertEquals(6, upcToPriceMap.size());
	}

	@When("^User Navigates to Create Shipment Page$")
	public void user_Navigates_to_Create_Shipment_Page() throws Throwable {
		//driver.get("http://localhost:8080/SimpleRetailWeb_PracticeGradedLab2/");
		driver.get("http://localhost:8082/SimpleRetailWeb_PracticeGradedLab2/");
		String xpathVal = "//input[@value='Get Items To Be Shipped']";
		WebElement btn = driver.findElement(By.xpath(xpathVal));
		btn.submit();
		assertTrue( driver.getCurrentUrl().contains("ShippingServlet"));
	}

	@Then("^upc should match corresponding price$ ")
	public void upc_should_match_corresponding_price() throws Throwable {

		List<WebElement> upcElements = driver.findElements(By.id("checkedRows"));
		List<WebElement> priceElements = driver.findElements(By.xpath("//tbody/tr/td[4]"));

		Map<String, String> pageUpcPriceMap = new HashMap<String, String>();

		for (int i = 0; i < upcElements.size(); i++) {
			pageUpcPriceMap.put(upcElements.get(i).getAttribute("value"), priceElements.get(i).getText());
		}

		assertEquals(upcToPriceMap.size(), pageUpcPriceMap.size());
		assertTrue(upcToPriceMap.equals(pageUpcPriceMap));

		System.out.println(upcToPriceMap);
		System.out.println(pageUpcPriceMap);
	}
	
	@After("@Web")
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
