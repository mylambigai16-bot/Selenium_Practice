package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class LoginDefinition {

    WebDriver driver;

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        driver = new EdgeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Given("Click on login")
    public void click_on_login() {
        driver.findElement(By.id("login2")).click();
    }

    @When("User enters valid username as {string} and password as {string}")
    public void user_enters_valid_username_as_and_password_as(String username, String password) {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("User should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        String welcomeMsg = driver.findElement(By.id("nameofuser")).getText();
        Assert.assertTrue(welcomeMsg.contains("Welcome"));

        driver.quit();
    }

    @When("the User enters username as {string} and invalid password as {string}")
    public void the_user_enters_username_as_and_invalid_password_as(String username, String password) {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("the User should get the error message")
    public void the_user_should_get_the_error_message() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert(); 

        String alertMsg = alert.getText();
        Assert.assertEquals(alertMsg, "Wrong password.");

        alert.accept();
        driver.quit();
    }
}
