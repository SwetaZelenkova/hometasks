package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.LoginPage;

public class AreIconsPresentSteps {

	private WebDriver driver;
	private LoginPage loginPage;

	public AreIconsPresentSteps() {
		driver = Driver.getInstance();
		loginPage = new LoginPage(driver);
	}
	
	@When("^The icons are present in the DOM and are displayed on the page$")
	public void countAllIcons() {
		assertTrue(loginPage.countAllIcons());
	}
	
	@Then("^I see all icons$")
	public void arePresentAndDisplayedAllIcons() {
		assertTrue(loginPage.arePresentAndDisplayedAllIcons());
	}
}
