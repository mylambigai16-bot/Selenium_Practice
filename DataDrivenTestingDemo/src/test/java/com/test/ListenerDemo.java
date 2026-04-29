package com.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " test case started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the testcase passed is :" + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase Skipped is :" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        Object currentClass = result.getInstance();
        WebDriver driver = ((LoginTest) currentClass).getDriver();

        takeScreenshot(driver, result.getName());
    }

    public void takeScreenshot(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "./seleniumScreenshot/" + testName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(src, new File(path));
            System.out.println("Screenshot saved at: " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
