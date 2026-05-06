package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/login.html"},
features = "src/test/resources/featureFile/Login.feature",
glue="com.stepDefinition")

public class LoginRunner extends AbstractTestNGCucumberTests{

}
