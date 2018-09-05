package edu.pht.cucumberjunit.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/FeatureFiles"},
        glue = {"edu.pht.cucumberjunit.steps"},
        tags = {"@FunctionalTests"},
        dryRun = false,
        strict = false
)
public class RunTest {
}
