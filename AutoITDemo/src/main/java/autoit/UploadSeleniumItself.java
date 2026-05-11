package autoit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadSeleniumItself {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/upload-download");
        WebElement file = driver.findElement(
                By.id("uploadFile"));
        file.sendKeys("\"C:\\Users\\Mylambigai\\OneDrive\\Documents\\expleo training\\ISTQB_CTFL_Syllabus-v4.0.pdf\"");
        
        
	}

}
