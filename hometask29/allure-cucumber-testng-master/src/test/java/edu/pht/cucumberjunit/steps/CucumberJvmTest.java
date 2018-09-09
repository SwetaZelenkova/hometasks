package edu.pht.cucumberjunit.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"features/featureFiles/CreateEmailWithDataFromXML.feature"},tags = {})
public class CucumberJvmTest extends AbstractTestNGCucumberTests {

}
