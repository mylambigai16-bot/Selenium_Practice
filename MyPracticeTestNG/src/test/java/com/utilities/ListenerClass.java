package com.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.BaseTest;

public class ListenerClass implements ITestListener {

    Logger logger = LogManager.getLogger(ListenerClass.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test Failed : " + result.getName());

        WebDriver driver = BaseTest.driver.get();

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File("Screenshots/" + result.getName() + ".png");

        destination.getParentFile().mkdirs();

        try {
            Files.copy(source.toPath(), destination.toPath());
            logger.info("Screenshot captured");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Execution Finished");
    }
}