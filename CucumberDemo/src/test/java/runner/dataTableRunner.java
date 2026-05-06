package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/dataTable.html"},
features = "src/test/resources/featureFile/dataTable.feature",
glue="stepDefinition")
public class dataTableRunner extends AbstractTestNGCucumberTests{

}
 