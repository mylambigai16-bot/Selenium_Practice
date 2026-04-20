package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProviderDemo_1 {
	private static final ThreadLocal <WebDriver> driver=new ThreadLocal <WebDriver>();
	
  @BeforeMethod
  public void setup() {
	  System.out.println("Start the test");
	  driver.set(new ChromeDriver());
  }

  @AfterMethod
  public void tearDown() {
	  WebDriver driver1=driver.get();
	  System.out.println(Thread.currentThread());
	  if(driver1 != null)
	  driver1.quit();
  } 
  
  @Test(dataProvider = "dp", dataProviderClass=DPClassDemo.class)
  public void search(String  keyword1) {
	  WebDriver driver1=driver.get();
	  driver1.get("https://www.bing.com/");
	  WebElement s=driver1.findElement(By.id("sb_form_q"));
	  s.sendKeys(keyword1);
	  System.out.println("Keyword: "+keyword1 );
	  s.sendKeys(Keys.ENTER);
  }


 
  }
