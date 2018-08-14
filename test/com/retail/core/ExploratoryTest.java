//package com.retail.core;
//
//
//import java.util.List;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//
//public class ExploratoryTest {
//
//	private WebDriver driver;
//
//	@Before("@Web")
//	public void setUp() {
//
//		
//	}
//
//	
//	
//	@Test
//	public void testGetItems() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"C:/Users/admin/SeleniumProjects/chromedriver_win32" + "/chromedriver.exe");
//         String btnValue = "Get Items To Be Shipped";
//         String xpathVal = "//input[@value=\"" + btnValue + "\"]";
//         
//		driver = new ChromeDriver();
//		driver.get("http://localhost:8080/SimpleRetailWeb_PracticeGradedLab2/index.html");
//		WebElement btn = driver.findElement(By.xpath(xpathVal));
//		btn.submit();
//		
//		
//		
//		List<WebElement> upcElements = driver.findElements(By.id("checkedRows"));
//		for (WebElement upcElement : upcElements) {
//			System.out.println(upcElement.getAttribute("value"));
//		}
//		//Thread.sleep(3000);
//		//List<WebElement> rows = driver.findElements(By.xpath("//input[@type='checkbox']ancestor::*"));
//		///html/body/form/table/tbody/tr[3]/td[4]
//		List<WebElement> priceElements = driver.findElements(By.xpath("//tbody/tr/td[4]"));
//				
//		for (WebElement priceElement : priceElements) {
//			System.out.println(priceElement.getText());
//		}
//	}
//	
////	@Test
////	public void testClickSubmitBtn() {
////		System.setProperty("webdriver.chrome.driver",
////				"C:/Users/admin/SeleniumProjects/chromedriver_win32" + "/chromedriver.exe");
////
////		driver = new ChromeDriver();
////		driver.get("http://localhost:8080/SimpleRetailWeb_PracticeGradedLab2/index.html");
////		WebElement btn = driver.findElement(By.xpath("//input[@value='Get Items To Be Shipped']"));
////		btn.click();
////		System.out.println(driver.getCurrentUrl());
////	}
//	
//	
//
//	@After("@Web")
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//	}
//
//}
