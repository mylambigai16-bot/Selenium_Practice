package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		WebElement iframeElement = driver.findElement(By.id("frame1Wrapper"));
		driver.switchTo().frame(iframeElement);
		
		WebElement inner=driver.findElement(By.id(""));
		
		driver.switchTo().defaultContent();
		//String mainpage=driver.findElement(By.id(""));
		

	}

}
