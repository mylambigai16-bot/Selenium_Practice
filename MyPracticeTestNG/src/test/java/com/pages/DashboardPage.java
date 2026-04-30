package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
  
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="nameofuser")
	public WebElement dashboardMsg;
	
	
}
