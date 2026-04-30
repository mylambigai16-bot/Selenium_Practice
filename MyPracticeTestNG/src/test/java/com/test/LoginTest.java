package com.test;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utilities.DPClass;

public class LoginTest extends BaseTest {
  @Test(dataProvider="valid", dataProviderClass=DPClass.class)
  public void validLogin(String name,String password) {
	  lp=new LoginPage(driver.get());
	  //WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
	  
	  lp.login(name,password);
  }
}
