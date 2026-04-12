package browser_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserClose {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		WebElement closeWindow=driver.findElement(By.xpath("//span[@class=\"ui-button-icon-right ui-icon ui-c pi pi-bookmark\"]/following-sibling::span"));
		closeWindow.click();
		WebElement show=driver.findElement(By.xpath("//button[@id=\"j_idt88:j_idt91\"]"));
		show.click();
		driver.close();
		 
	}

}
