package browser_commands;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlaze {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement loginbutton =driver.findElement(By.xpath("//a[text()=\"Log in\"]"));
		loginbutton.click();
		WebElement login=driver.findElement(By.id("loginusername"));
		login.sendKeys("admin");
		WebElement password=driver.findElement(By.xpath("//label[@for=\"log-pass\"]/following-sibling::input"));
		password.sendKeys("admin");
		driver.findElement(By.cssSelector("button[onclick=\"logIn()\"]")).click();
		WebElement welcome=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Welcome admin']")));
		if(welcome.getText().equals("Welcome admin"))
		System.out.println("Login Successful!");
		driver.close();

	}

}
