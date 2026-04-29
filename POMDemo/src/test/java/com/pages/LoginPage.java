package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public  LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//h5[text()='Login']")
	public WebElement titleName;
	
	@FindBy(tagName="button")
	public  WebElement login;
	
	
	
	
	public void login1(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		login.click();
	}
	public String getTitle() {
		return titleName.getText();
	}
	
}
