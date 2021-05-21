package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/Features/Favorite.feature",glue= {"TestingSteps"},
plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber.xml"})
public class Runner {

}
