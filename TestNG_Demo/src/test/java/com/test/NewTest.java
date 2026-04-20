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

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	public void setup() {
	    System.out.println("Start the test");
	    WebDriver driver1 = new ChromeDriver();
	    driver.set(driver1);
	    driver1.get("https://www.demoblaze.com/");
	    driver1.manage().window().maximize();
	}


	@AfterMethod
	public void tearDown() {
		WebDriver driver1 = driver.get();
		if (driver1 != null)
			driver1.quit();
	}

	@Test
	@Parameters({ "userName1", "passWord1" })
	public void valid(String name, String password) {
		WebDriver driver1 = driver.get();
		driver1.findElement(By.id("login2")).click();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
		driver1.findElement(By.id("loginpassword")).sendKeys(password);
		driver1.findElement(By.xpath("//button[text()='Log in']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id=\"nameofuser\"]")));
		String actual = driver1.findElement(By.xpath("//a[@id=\"nameofuser\"]")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual, "Welcome mylu", "Login not successful");
	}

	@Test(dataProvider = "dp", dataProviderClass = DPClassDemo.class)

	public void Invalid1(String name, String password) {
		WebDriver driver1 = driver.get();
		driver1.findElement(By.id("login2")).click();

		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
		driver1.findElement(By.id("loginpassword")).sendKeys(password);
		driver1.findElement(By.xpath("//button[text()='Log in']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver1.switchTo().alert();
		alert.accept();
		System.out.println("Invalid 1 run successful!");
	}

	/*
	 * @Test
	 * 
	 * public void Ivalid2(String name,String password) {
	 * driver.findElement(By.id("login2")).click(); WebDriverWait wait=new
	 * WebDriverWait(driver,Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
	 * "loginusername"))).sendKeys(name);
	 * driver.findElement(By.id("loginpassword")).sendKeys(password);
	 * driver.findElement(By.xpath("//button[text()='Log in']")).click();
	 * wait.until(ExpectedConditions.alertIsPresent()); Alert alert =
	 * driver.switchTo().alert(); alert.accept();
	 * System.out.println("Invalid 2 run successful!"); }
	 */

}
