package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/regression.html"},
        features = "src/test/resources/Features",
        glue = "stepDefinitions",
        tags = "@tek",
        dryRun =false
)

public class Runner {
}
