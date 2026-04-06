package browser_commands;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//implicit wait
public class ImplicitWaitDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Add=driver.findElement(By.id("adder"));
		Add.click();
		WebElement b1=driver.findElement(By.id("box0"));
		String css1=b1.getCssValue("width");
		System.out.println(css1);
		driver.close();
	}

}
