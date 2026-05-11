package autoit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autoit {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://pdf2doc.com/");

        WebElement file = driver.findElement(By.xpath("//label[@id='uploadBtn']"));

        file.click();

        Runtime.getRuntime().exec(
            "C:\\Users\\Mylambigai\\OneDrive\\Documents\\expleo training\\AutoitDemo\\Demo.exe"
        );
    }
}