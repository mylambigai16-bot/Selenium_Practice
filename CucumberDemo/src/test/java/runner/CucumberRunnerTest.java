package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin="pretty",
features="src/test/resources/featureFile/login.feature",tags="@ValidCredentials",glue="stepDefinition")
public class CucumberRunnerTest {
	
	
}
