package javaScriptAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSLogin {
	public static void main(String args[]) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String domain=js.executeScript("return document.domain;").toString();
		System.out.println(domain);
		String url=js.executeScript("return document.URL;").toString();
		System.out.println(url);
	}
}
