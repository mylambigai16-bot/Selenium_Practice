package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node04n8rc0dstozdzwi2iarbe0pi14556601.node0");
        WebElement drop=driver.findElement(By.xpath("//span[@class=\"ui-button-text\"]"));
        Select dropDown=new Select(drop);
        List <WebElement> list=dropDown.getOptions();
        System.out.println("List size: "+list.size());
        for(WebElement ele:list) {
        	System.out.println(ele.getText());
        }
        boolean multiple = dropDown.isMultiple();
        System.out.println(multiple);
        dropDown.selectByIndex(1);
        dropDown.selectByVisibleText("");
        

	}

}
