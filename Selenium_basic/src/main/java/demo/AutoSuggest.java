package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement search=driver.findElement(By.xpath("//li[@class=\"ui-autocomplete-input-token\"]/child::input"));
        search.click();
        search.sendKeys("selenium");
        
        List<WebElement> suggest=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@id=\"j_idt87:auto-complete_panel\"]/child::ul/child::li")));
        
        for(WebElement option:suggest) {
        	if(option.getText().equals("Selenium WebDriver")) {
        		option.click();
        		break;
        	}
        }
        search.sendKeys("some", Keys.ENTER);
	}

}
