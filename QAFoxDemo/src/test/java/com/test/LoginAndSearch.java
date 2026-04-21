package com.test;

import org.testng.annotations.Test;

import com.utilities.DPExcelData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginAndSearch {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	public void setup() {
		WebDriver driver1 = new ChromeDriver();
		driver.set(driver1);
		driver1.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver1.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		WebDriver driver1 = driver.get();
		driver1.quit();
	}

	@Test(dataProvider = "validlogin", dataProviderClass = DPExcelData.class)
	public void validLogin(String email, String password) {
		WebDriver driver1 = driver.get();
		driver1.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver1.findElement(By.xpath("//li/a[text()='Login']")).click();
		driver1.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(email);
		driver1.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(password);
		driver1.findElement(By.cssSelector("input[value=\"Login\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Orders']")));
		boolean myOrder = driver1.findElement(By.xpath("//h2[text()='My Orders']")).isDisplayed();
		Assert.assertTrue(myOrder, "Login not successful!");
	}

	@Test(dataProvider = "invalidlogin", dataProviderClass = DPExcelData.class)
	public void invalidLogin(String email, String password) {
		WebDriver driver1 = driver.get();
		driver1.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver1.findElement(By.xpath("//li/a[text()='Login']")).click();
		driver1.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(email);
		driver1.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(password);
		driver1.findElement(By.cssSelector("input[value=\"Login\"]")).click();
		String warningMsg = driver1.findElement(By.xpath("//div[contains(@class,'danger')]")).getText();
		Assert.assertEquals(warningMsg, "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test(dataProvider="validsearch",dataProviderClass = DPExcelData.class)
	public void validSearch(String keyword) {
		WebDriver driver1=driver.get();
		driver1.findElement(By.cssSelector("input[name=\"search\"]")).sendKeys(keyword);
		driver1.findElement(By.xpath("//span/child::button[@type=\"button\"]")).click();
		WebDriverWait wait=new WebDriverWait(driver1,Duration.ofSeconds(10));
		Boolean serachProduct=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//a[contains(text(),'Mac')]"))).isDisplayed();
		Assert.assertTrue(serachProduct);
	}
}
