package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginDefinition {
	
	WebDriver driver;

	@Before
	public void setup() {

		driver = new ChromeDriver();  
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Given("the user clicks on My Account link and then clicks on Login link")
	public void the_user_clicks_on_my_account_link_and_then_clicks_on_login_link() {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	   
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']"))).click();
	   driver.findElement(By.cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/login']")).click();
	}

	@When("the user enter valid email address as {string}  and password as {string}")
	public void the_user_enter_valid_email_address_as_and_password_as(String emailAddress, String password) {
	    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailAddress);
	    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	}
	@When("click on Login button")
	public void click_on_login_button() {
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("the user should able to login successfully")
	public void the_user_should_able_to_login_successfully() {
		System.out.println(driver.getCurrentUrl());
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement LoginAssert=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Edit your account information']")));
		System.out.println(LoginAssert.getText());
		Assert.assertTrue(LoginAssert.isDisplayed());
	    
	}

	@When("the user enters Invalid email addres as {string} and password as {string}")
	public void the_user_emters_invalid_email_addres_as_and_password_as(String emailAddress, String password) {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailAddress);
	    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	}
	
	@When("the user clicks on login button")
	public void the_user_clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("the user should get the error message")
	public void the_user_should_get_the_error_message() {
	    String error=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	    Assert.assertEquals(error,"Warning: No match for E-Mail Address and/or Password.");
	}


}
