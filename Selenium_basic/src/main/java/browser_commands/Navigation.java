package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("hhtp://ww.google.com");
		//Thread.sleep(5000);
		driver.navigate().to("hhtp://www.smartclif.in");
		//Thread.sleep(5000);
		driver.navigate().back();
		//Thread.sleep(5000);
		driver.navigate().forward();
		//Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("Title: "+driver.getTitle());
		//Thread.sleep(5000);
		driver.close();
	}

}
