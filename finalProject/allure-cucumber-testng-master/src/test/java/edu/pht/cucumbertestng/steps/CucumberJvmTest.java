package edu.pht.cucumbertestng.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"features/featureFiles"},
tags = {"@FunctionalTests", "~@GorillaTests"})
public class CucumberJvmTest extends AbstractTestNGCucumberTests {

}
