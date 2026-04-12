package tableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InFirstRow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/#");

        List<WebElement> Firstdata = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        System.out.println(Firstdata.size());

        for(WebElement all : Firstdata) {
            System.out.println(all.getText());
        }
        driver.quit();

	}

}
