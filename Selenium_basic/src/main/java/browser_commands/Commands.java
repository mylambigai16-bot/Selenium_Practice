package browser_commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//flipkart
public class Commands {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.get("https://www.flipkart.com/");
		String title=driver.getTitle();       //get title method
		System.out.println("Title: "+title);
		System.out.println("Title length: "+title.length());  //get length method
		if(("https://www.flipkart.com/").contains(driver.getTitle()))
			System.out.println("Same");
		else
			System.out.println("Not same");
		String pageSource=driver.getPageSource();       //get page source
		System.out.println("Page source: "+pageSource);
		System.out.println("Page source length: "+pageSource.length()); //page source length
		driver.close();


	}

}
