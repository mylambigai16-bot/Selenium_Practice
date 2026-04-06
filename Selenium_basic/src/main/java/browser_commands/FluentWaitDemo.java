package browser_commands;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		driver.findElement(By.xpath("//div[@class=\"dropdown\"]/child::button")).click();
		driver.findElement(By.xpath("//div[@id=\"myDropdown\"]/child::a[text()='Facebook']")).click();
		
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
		            .withTimeout(Duration.ofSeconds(30))
		            .pollingEvery(Duration.ofMillis(1))
		            .ignoring(ElementNotInteractableException.class);

		WebElement fb=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.linkText("Facebook"));
			}
		});
		fb.click();
		driver.close();
	}

}
