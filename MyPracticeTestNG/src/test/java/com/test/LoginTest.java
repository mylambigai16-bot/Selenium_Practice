package com.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utilities.DataProviderClass;
import com.utilities.ListenerClass;

@Listeners(ListenerClass.class)
public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void loginTest(String username, String password) {

        logger.info("Login Test Started");

        LoginPage lp = new LoginPage(driver.get());

        lp.login(username, password);

        // Intentionally failed assertion for screenshot
        Assert.assertEquals(driver.get().getTitle(), "WrongTitle");

        logger.info("Login Test Completed");
    }
}