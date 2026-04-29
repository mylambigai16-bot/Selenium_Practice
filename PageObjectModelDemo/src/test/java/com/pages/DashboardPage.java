package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	By DashBoard=By.xpath("//h6[text()='Dashboard']");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageText() {
		return driver.findElement(DashBoard).getText();
		}

}
