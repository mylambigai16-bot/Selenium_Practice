package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class Demo_practice {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
		WebElement  search=driver.findElement(By.name("q"));
		search.sendKeys("selenium",Keys.ENTER);
		System.out.println("page title is:"+driver.getTitle());
		driver.close();
	}

}
