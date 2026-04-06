package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Ralative_locators {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		System.out.println("Hello Welcome!");
		driver.manage().window().maximize();
		//driver.get("hhtp://www.google.com");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//WebElement element1=driver.findElement(By.xpath("//label[text()='First Name ']/following-sibling::input[1]"));
		//element1.sendKeys("Myl");
		driver.findElement(By.cssSelector("input[maxlength='10']")).sendKeys("Myl");
		WebElement element2=driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input[1]"));
		element2.sendKeys("G");
		WebElement element3=driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[1]"));
		element3.sendKeys("myl@2005");
		WebElement element4=driver.findElement(By.xpath("//div[@class='container']/child::div/child::input[@type='password']"));
		element4.sendKeys("Password");
		WebElement element5=driver.findElement(By.xpath("//label[text()='Repeat Password']/following-sibling::input"));
		element5.sendKeys("Password");
		//driver.close();
	}

}
