package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	
	public WebDriver driver; 
  @BeforeMethod
  @Parameters({"Browser","url"})
  public void beforeMethod(String Browser,String url) {
	  //System.out.println("Test start");
	  if(Browser.equals("Chrome")) {
	  ChromeOptions option=new ChromeOptions();
	  option.addArguments("--start-maximized");
	  //option.addArguments("--headless");
	  driver = new ChromeDriver(option);
	  driver.get(url);
	  }
	  else if(Browser.equals("Edge")) {
		  EdgeOptions option=new EdgeOptions();
		  option.addArguments("--start-maximized");
		  //option.addArguments("--headless");
		  driver = new EdgeDriver(option);
		  driver.get(url);
	  }
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test 
  @Parameters({"userName1","passWord1"})
  public void valid(String name,String password) {
	  driver.findElement(By.id("login2")).click();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
	  driver.findElement(By.id("loginpassword")).sendKeys(password);
	  driver.findElement(By.xpath("//button[text()='Log in']")).click(); 
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id=\"nameofuser\"]")));
	  String actual=driver.findElement(By.xpath("//a[@id=\"nameofuser\"]")).getText();
	  System.out.println(actual);
	  Assert.assertEquals(actual, "Welcome mylu","Login not successful");
  }
  
  @Test (dataProvider="dp",dataProviderClass=DPClassDemo.class)
  
  public void Invalid1(String name,String password) {
	  driver.findElement(By.id("login2")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
	  driver.findElement(By.id("loginpassword")).sendKeys(password);
	  driver.findElement(By.xpath("//button[text()='Log in']")).click(); 
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  System.out.println("Invalid 1 run successful!");
  }
  
  /*@Test 
 
  public void Ivalid2(String name,String password) {
	  driver.findElement(By.id("login2")).click();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
	  driver.findElement(By.id("loginpassword")).sendKeys(password);
	  driver.findElement(By.xpath("//button[text()='Log in']")).click(); 
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  System.out.println("Invalid 2 run successful!");
  }  */

}
