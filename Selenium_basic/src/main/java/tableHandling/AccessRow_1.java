package tableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessRow_1 {

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

        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='myTable']//tr[1]//th"));
        int colCount = cols.size();
        System.out.println("Columns: " + colCount);

        for (int r = 1; r <= rowsCount; r++) {
            for (int c = 1; c <= colCount; c++) {

                WebElement data;

                // Header row
                if (r == 1) {
                    data = driver.findElement(By.xpath("//table[@id='myTable']//tr[" + r + "]//th[" + c + "]"));
                } else {
                    data = driver.findElement(By.xpath("//table[@id='myTable']//tr[" + r + "]//td[" + c + "]"));
                }

                System.out.print(data.getText() + "  ");
            }
            System.out.println();
        }
    }
}
