package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Linked in
public class LinkedIn {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/home");
		driver.findElement(By.cssSelector("a[class=\"nav__button-secondary btn-secondary-emphasis ml-3 btn-md\"]")).click();
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys("mylambigaimyla@gmail.com");
		driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("mylu0616");
		driver.findElement(By.cssSelector("button[class=\"btn__primary--large from__button--floating\"]")).click();
		driver.close();
	}

}
