package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListByAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");

        Actions act = new Actions(driver);

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dropDown=driver.findElement(By.xpath("//li[@class=\"ui-autocomplete-input-token\"]/child::input"));
        
        Select select=new Select(dropDown);
        //List<WebElement> options=dropDown.getOptions();
        
	}

}
