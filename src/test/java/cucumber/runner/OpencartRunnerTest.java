package cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "cucumber.steps",
        features = "src/test/resources/features/",
        plugin = {"pretty", "html:target/cucumber.html"},
        tags = "@opencart")

public class OpencartRunnerTest {

}
