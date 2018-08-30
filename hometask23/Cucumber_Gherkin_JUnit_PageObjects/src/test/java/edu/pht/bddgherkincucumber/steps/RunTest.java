package edu.pht.bddgherkincucumber.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/features"},
        glue = {"edu.pht.bddgherkincucumber.steps"},
        dryRun = false,
        strict = false
)
public class RunTest {
}
