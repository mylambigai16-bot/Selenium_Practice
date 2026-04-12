package tableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alldata {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/#");

        List<WebElement> data = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));

        System.out.println(data.size());

        for(WebElement all : data) {
            System.out.println(all.getText());
        }
        driver.quit();
	}

}
