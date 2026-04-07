package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droppable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.cssSelector("div[id=\"form:conpnl\"]"));
		act.dragAndDropBy(drag, 500, 0).perform();
		driver.close();

	}

}
