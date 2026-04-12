package tableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintTable {

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
        for(int r=1;r<=rowsCount;r++) {
        	for(int c=1;c<=colCount;c++) {
        		WebElement data;
        		if(r==1) {
        			data=driver.findElement(By.xpath("//table[@id='table1']//tr["+r+"]//th["+c+"]"));
        		}
        		else {
        			data=driver.findElement(By.xpath("//table[@id='table1']//tr["+r+"]//td["+c+"]"));
        		}
        		System.out.print(data.getText());
        	}
        	
        }
	}

}
