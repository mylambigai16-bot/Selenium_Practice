package keyAction;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebElementAction {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/#");

        Actions act = new Actions(driver);

        WebElement link = driver.findElement(By.linkText("compendiumdev"));

        // Open in new tab
        act.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();

        String parentWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                System.out.println("Child window title: " + driver.getTitle());
            }
        }

        Thread.sleep(2000);

        driver.switchTo().window(parentWindow);
        System.out.println("Back to parent: " + driver.getTitle());

        driver.quit();
    }
}
