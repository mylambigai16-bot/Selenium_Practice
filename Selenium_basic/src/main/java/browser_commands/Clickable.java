package browser_commands;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//omayo 
//Element to be clickable
public class Clickable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement timebutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("alert2")));
		timebutton.click();
		driver.close();
	}

}
