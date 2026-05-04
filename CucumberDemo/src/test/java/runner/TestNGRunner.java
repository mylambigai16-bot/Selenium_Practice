package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/Cucumber.html"},
features = "src/test/resources/featureFile/login.feature",
tags="@myl and @InvalidCredential" ,
glue="stepDefinition")


public class TestNGRunner extends AbstractTestNGCucumberTests {

}
