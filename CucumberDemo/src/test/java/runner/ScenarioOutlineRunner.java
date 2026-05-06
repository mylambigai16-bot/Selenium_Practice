package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty",
		"html:target/cucumber-reports/ScenarioCucumber.html" }, features = "src/test/resources/featureFile/sceanrioOutline.feature", glue = "stepDefinition")

public class ScenarioOutlineRunner extends AbstractTestNGCucumberTests {

}
