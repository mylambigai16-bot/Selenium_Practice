package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login2")
    WebElement loginButton;

    @FindBy(id = "loginusername")
    public WebElement username;

    @FindBy(id = "loginpassword")
    public WebElement password;

    @FindBy(css = "button[onclick='logIn()']")
    WebElement submitButton;

    public void login(String user, String pass) {
        loginButton.click();
        username.sendKeys(user);
        password.sendKeys(pass);
        submitButton.click();
    }
}