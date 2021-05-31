package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",
                  glue={"stepdefinition"},
                  plugin={"json:target/jsonreports/cucumber-report.html","json:target/jsonreports/cucumber-report.json"})
public class TestRunner {

}
