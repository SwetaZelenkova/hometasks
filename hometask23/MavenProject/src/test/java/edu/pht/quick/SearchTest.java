package edu.pht.quick;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java",
        glue = "edu.pht.quick",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE
)
public class SearchTest {

}
