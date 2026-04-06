package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Thread Sleep
public class Omayo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		driver.findElement(By.xpath("//div[@class=\"dropdown\"]/child::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id=\"myDropdown\"]/child::a[text()='Facebook']")).click();
		driver.close();
	}

}
