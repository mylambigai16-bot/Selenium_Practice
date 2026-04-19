package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class SoftAssertionDemo {

	public WebDriver driver;
	SoftAssert sa=new SoftAssert();
	
	@BeforeMethod
	public void beforeMethod() {
		// System.out.println("Test start");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		// option.addArguments("--headless");
		driver = new ChromeDriver(option);
		driver.get("https://www.demoblaze.com/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void verifyTitle() {
		String  expected="STORE";
		String actual=driver.getTitle();
		sa.assertEquals(actual, expected,"Not same");
		sa.assertAll();
	}

}
