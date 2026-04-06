package browser_commands;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//send key to the box
//get value and print
public class GetValue {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement Add=driver.findElement(By.cssSelector("input[value=\"Reveal a new input\"]"));
		Add.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement txt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id=\"revealed\"]")));
		txt.sendKeys("Myl");
		System.out.println(txt.getAttribute("value"));
	    driver.close();

	}

}
