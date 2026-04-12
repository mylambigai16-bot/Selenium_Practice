package tableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeadingsOftable {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/#");

        List<WebElement> headings = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println(headings.size());

        for(WebElement head : headings) {
            System.out.println(head.getText());
        }
        driver.quit();
    }
}
