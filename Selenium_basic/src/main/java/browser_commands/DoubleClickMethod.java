package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickMethod {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		Actions act = new Actions(driver);
		WebElement doubleClick = driver.findElement(By.cssSelector("button[ondblclick=\"dblclickAlert()\"]"));
		act.doubleClick(doubleClick).perform();
		driver.close();
	}

}
