package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="login2")
	public WebElement login_btn;
	
	@FindBy(id="loginusername")
	public WebElement username;
	
	@FindBy(id="loginpassword")
	public WebElement password;
	
	@FindBy(css="button[onclick=\"logIn()\"]")
	public WebElement Login;
	
	public void login(String name,String pass) {
		login_btn.click(); 
		username.sendKeys(name);
	}

}
