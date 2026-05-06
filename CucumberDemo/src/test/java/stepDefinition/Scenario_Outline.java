package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Scenario_Outline {

	WebDriver driver;

	@Before
	public void setup() {

		driver = new ChromeDriver();

		driver.get("https://www.demoblaze.com/index.html");
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	@Given("User is on Login page")
    public void user_is_on_login_page() {
        
    }

	@And("User click on the Login link")
	public void user_click_on_the_login_link() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2"))).click();
	}

	@When("the User enters username as {string} and the password as {string}")
	public void the_user_enters_username_as_and_the_password_as(DataTable dataTable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

		List<List<String>> logIn = dataTable.asLists(String.class);
		String username = logIn.get(0).get(0);
		String password = logIn.get(0).get(1);

		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);

	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("User get the message like {string}")
	public void user_get_the_message_like(String errorMsg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		String alertMsg = alert.getText();
		Assert.assertEquals(alertMsg, errorMsg);

		alert.accept();
	}

}
