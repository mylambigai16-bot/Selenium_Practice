package tableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableDataAccess {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(By.id("email")).sendKeys("myl@gmail.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("submit")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='myTable']//tr"));
        int rowsCount = rows.size();
        System.out.println("Rows: " + rowsCount);

        List<WebElement> cols = driver.findElements(By.xpath(" "));
        int colCount = cols.size();
        System.out.println("Columns: " + colCount);
        
        List<WebElement> contactName = driver.findElements(By.xpath("//table[@id='myTable']//tr//td[2]"));
        int contactCount=contactName.size();
        for(WebElement Name:contactName) {
        	System.out.println(Name.getText());
        }
        	
        String expectedName="Adhira G";
        
        int i=0;
        for(WebElement name:contactName) {
        	if(name.getText().equals(expectedName)) {
        		List<WebElement> actualRowData=driver.findElements(By.xpath("//table[@id='myTable']/tr["+i+"]"));
        		for(WebElement row:actualRowData) {
        			System.out.println(row.getText());
        		}
        	}
        	i++;
        }
        driver.quit();

	}

}
