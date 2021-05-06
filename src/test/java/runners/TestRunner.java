package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = {"classpath:features"},
				glue = {"stepDefinitions", "ApplicationHooks"},
				plugin = {"pretty", "html:target/cucumber-html-report"
						, "json:target/JsonReport/cucumber.json", "junit:target/JunitReport/cucumber.xml"
						}
//				dryRun = false
				)

public class TestRunner {

}
