package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath="//input[@placeholder='Username']")
	public WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement password;
	
	@FindBy(css="button[type='submit']")
	public WebElement login_btn;
	

}
