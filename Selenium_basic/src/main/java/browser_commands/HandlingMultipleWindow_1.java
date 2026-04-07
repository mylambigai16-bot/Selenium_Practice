package browser_commands;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindow_1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/");
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
		Set<String> allWindow=driver.getWindowHandles();
		System.out.println("Cout of Window: "+allWindow.size());
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		
		Set<String> newWindowHandle=driver.getWindowHandles();
		System.out.println("New count: "+newWindowHandle.size());
		
		Iterator<String> iterator=newWindowHandle.iterator();
		String mainWindow=iterator.next();
		String child=iterator.next();
		System.out.println(child);
		
		driver.switchTo().window(child);
		
		WebElement text=driver.findElement(By.xpath("//span[text()=\"Browser Windows\"]"));
		text.click();
		WebElement newWindow=driver.findElement(By.id("windowButton"));
		driver.quit();
	}

}
