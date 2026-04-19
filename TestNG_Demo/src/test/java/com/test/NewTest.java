package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	
	public WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //System.out.println("Test start");
	  ChromeOptions option=new ChromeOptions();
	  option.addArguments("--start-maximized");
	  //option.addArguments("--headless");
	  driver = new ChromeDriver(option);
	  driver.get("https://www.demoblaze.com/");
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test 
  public void valid() {
	  driver.findElement(By.id("login2")).click();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("mylu");
	  driver.findElement(By.id("loginpassword")).sendKeys("myl0616");
	  driver.findElement(By.xpath("//button[text()='Log in']")).click(); 
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id=\"nameofuser\"]")));
	  String actual=driver.findElement(By.xpath("//a[@id=\"nameofuser\"]")).getText();
	  System.out.println(actual);
	  Assert.assertEquals(actual, "Welcome mylu","Login not successful");
  }
  
  @Test 
  public void Invalid1() {
	  driver.findElement(By.id("login2")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("my");
	  driver.findElement(By.id("loginpassword")).sendKeys("myl0616");
	  driver.findElement(By.xpath("//button[text()='Log in']")).click(); 
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  System.out.println("Invalid 1 run successful!");
  }
  
  @Test 
  public void Ivalid2() {
	  driver.findElement(By.id("login2")).click();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("mylu");
	  driver.findElement(By.id("loginpassword")).sendKeys("my");
	  driver.findElement(By.xpath("//button[text()='Log in']")).click(); 
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  System.out.println("Invalid 2 run successful!");
  }  

}
