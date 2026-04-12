package tableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumOfRowCol {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/#");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowsCount=rows.size();
        
        List<WebElement> col = driver.findElements(By.xpath("//table[@id='table1']//th"));
        int colCount=col.size();

        System.out.println(rowsCount);
        System.out.println(colCount);
        driver.quit();

	}

}
