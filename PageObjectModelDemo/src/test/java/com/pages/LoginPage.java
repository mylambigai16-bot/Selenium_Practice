package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By userName=By.cssSelector("input[name=\"username\"]");
	By passWord=By.cssSelector("input[name=\"password\"]");
	By titleName=By.xpath("//h5[text()='Login']");
	By login=By.tagName("button");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void setUsername(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	public void setPassword(String password) {
		driver.findElement(passWord).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(login).click();
	}
	public String getTitle() {
		return driver.findElement(titleName).getText();
	}
	public void login(String username,String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickLogin();
	}
}
