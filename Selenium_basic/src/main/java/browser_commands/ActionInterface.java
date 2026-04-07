package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionInterface {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		Actions act=new Actions(driver);
		WebElement blog=driver.findElement(By.id("blogsmenu"));
		act.moveToElement(blog).perform();
		
		WebElement option=driver.findElement(By.xpath("//a[@href='http://www.selenium-by-arun.blogspot.com']"));
		act.click(option).build();
		//driver.close();

	}

}
