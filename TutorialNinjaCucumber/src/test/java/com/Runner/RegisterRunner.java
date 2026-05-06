package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/register.html"},
features = "src/test/resources/featureFile/Registration.feature",
glue="com.stepDefinition")
public class RegisterRunner extends AbstractTestNGCucumberTests {

}
