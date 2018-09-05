package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;

public class EmailsMarkedWithFlagSteps {

	private WebDriver driver;
	private EmailPage emailPage;

	public EmailsMarkedWithFlagSteps() {
		driver = Driver.getInstance();
		emailPage = new EmailPage(driver);
	}

	@And("^I choose the three emails$")
	public void checkEmailsToMark() {
		emailPage.checkEmailsToMark();
	}

	@And("^I click on the button more actions$")
	public void clickButtonMoreActions() {
		emailPage.clickButtonMoreActions();
	}

	@And("^I click the flag link$")
	public void clickMarkFlagLink() {
		emailPage.markFlag();
	}

	@Then("^I see message Your emails has been marked with flag$")
	public void isNotifyMessageMarkedWithFlagPresents() {
		assertTrue(emailPage.isNotifyMessageMarkedWithFlagPresents());
	}
}
