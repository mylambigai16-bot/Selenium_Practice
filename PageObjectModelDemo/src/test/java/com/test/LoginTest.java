package com.test;

import org.testng.annotations.Test;

import com.pages.LoginPage;

import org.testng.Assert;

public class LoginTest extends BaseTest{
	
	
	
  @Test
  public void loginTest() {
	  loginObj=new LoginPage(driver);
	  
	  String loginPageTitle=loginObj.getTitle();
	  Assert.assertTrue(loginPageTitle.contains("Login"));
  }

}
