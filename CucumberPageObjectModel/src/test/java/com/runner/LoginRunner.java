package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/featureFiles/Login.feature",
    
    glue = "com.definition",

//    plugin = { 
//        "pretty",
//        "html:target/cucumber-reports.html",
//        "json:target/cucumber-reports.json",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//    },

//    plugin= {"pretty","io.qemeta.allure.cucumber7jvm.AllureCucumber7jvm"},
//    monochrome = true
//
    plugin= { "rerun:target/failed_scenarios.txt"}
    
		)

public class LoginRunner extends AbstractTestNGCucumberTests {

}