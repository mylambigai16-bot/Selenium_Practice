package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.pages.LoginPage;
import com.utilities.HelperClass;

public class LoginAction {
	
	LoginPage loginPage ;
	String username,password;
	
	public LoginAction() {
		this.loginPage=new LoginPage();
		PageFactory.initElements(HelperClass.getDriver(), loginPage);
	}
	public void setUsername(String username) {
		loginPage.username.sendKeys(username);
	}
	public void setPassword(String password) {
		loginPage.password.sendKeys(password);
	}
	public void clickLogin() {
		loginPage.login_btn.click();
	}
	public void login() {
		File file=new File("src/test/resources/data.properties");
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties pro=new Properties();
		
		try{
			pro.load(fis);
		}
	    catch(Exception e) {
	    	    e.printStackTrace();
		}
		
		username=pro.getProperty("username");
		password=pro.getProperty("password");
		
		this.setUsername(username);
		this.setPassword(password);
		this.clickLogin();
		
	}

}
