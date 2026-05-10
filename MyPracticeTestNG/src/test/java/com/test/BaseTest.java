package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {

        WebDriver localDriver = new ChromeDriver();

        driver.set(localDriver);

        driver.get().manage().window().maximize();

        driver.get().get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() {

        driver.get().quit();

        driver.remove();
    }
}