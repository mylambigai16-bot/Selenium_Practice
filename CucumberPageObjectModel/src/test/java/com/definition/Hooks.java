package com.definition;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utilities.HelperClass;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static final Logger logger=LogManager.getLogger(Hooks.class);
	
	@Before
	public static void setup() {
		HelperClass.setupDriver();
	}

	@After
	public static void tearDown(Scenario sceanario) {
		if(sceanario.isFailed()) {
			File ss=((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			File destinationFile= new File("screenshots/"+sceanario.getName().replaceAll("","_")+".png");
			FileUtils.copyFile(ss,destinationFile);
			
			byte[] screenshotBytes=((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
			sceanario.attach(screenshotBytes,"image/png","Failure Screenshot");
			logger.error("Sceanrio failed "+sceanario.getName());
					
		}
		catch(Exception e) {
			logger.error("Falied to save screenshot {}",e.getMessage());
		}
		}
		else {
			logger.info("Scenario passed: {}",sceanario.getName());
		}
		HelperClass.tearDown();
	}
}
