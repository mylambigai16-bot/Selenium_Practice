package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public static final ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	public static Logger logger=LogManager.getLogger(BaseTest.class );
	
	@BeforeMethod
	public void setUp() {
		WebDriver driver1=new ChromeDriver();
		driver.set(driver1);
		driver1.manage().window().maximize();
		driver1.get("https://www.demoblaze.com/");
	
	}
	@AfterMethod 
	public void tearDown() {
		WebDriver driver1=driver.get();
		if(driver1!=null)
			driver1.quit();
	}
}
