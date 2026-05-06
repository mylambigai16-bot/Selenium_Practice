package com.stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class RegistrationDefinition {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}
	
	@After 
	public void tearDown() {
		driver.quit();
	}
	@Given("the user is on the Home page")
	public void the_user_is_on_the_home_page() {
	    
	}

	@Given("the user clicks on My Account link and then clicks on Registration link")
	public void the_user_clicks_on_my_account_link_and_then_clicks_on_registration_link() {
	    driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	    driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}

	@When("the user enters registration details")
	public void the_user_enters_registration_details(io.cucumber.datatable.DataTable dataTable) {
		
		List<List<String>> logIn = dataTable.asLists(String.class);
		String f_name = logIn.get(0).get(0);
		String l_name = logIn.get(0).get(1);
		String email = logIn.get(0).get(2);
		String phoneNum = logIn.get(0).get(3);
		String password = logIn.get(0).get(4);
		String passwordConfirm = logIn.get(0).get(5);
	    driver.findElement(By.cssSelector("input[id='input-firstname']")).sendKeys(f_name);
	    driver.findElement(By.cssSelector("input[id='input-lastname']")).sendKeys(l_name);
	    driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
	    driver.findElement(By.cssSelector("input[id=\"input-telephone\"]")).sendKeys(phoneNum);
	    driver.findElement(By.cssSelector("input[id='input-password']")).sendKeys(password);
	    driver.findElement(By.cssSelector("input[id=\"input-confirm\"]")).sendKeys(passwordConfirm);
	    
	    
	}

	@When("the user agrees to the privacy policy")
	public void the_user_agrees_to_the_privacy_policy() {
	    driver.findElement(By.cssSelector("input[name=\"agree\"]")).click();
	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() {
	    driver.findElement(By.cssSelector("input[value=\"Continue\"]")).click();
	}

	@Then("the user should see a successful registration message")
	public void the_user_should_see_a_successful_registration_message() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	    String loginAssert=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))).getText();

	    Assert.assertEquals(loginAssert,"Your Account Has Been Created!");
	}

}
