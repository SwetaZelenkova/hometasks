package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;

public class UnmarkAllFlagsSteps {

	private WebDriver driver;
	private EmailPage emailPage;

	public UnmarkAllFlagsSteps() {
		driver = Driver.getInstance();
		emailPage = new EmailPage(driver);
	}

	@And("^I click on the button filter the emails marked with a check mark$")
	public void clickButtonToFilterEmails() {
		emailPage.filterEmailsWithFlags();
	}

	@And("^I choose all emails$")
	public void checkEmailsToUnmark() {
		emailPage.checkEmailsToUnmark();
	}

	@And("^I click on the uncheck the flag link$")
	public void clickUnmarkFlagLink() {
		emailPage.checkEmailsToUnmark();
	}

	@Then("^I see message no emails that fall under the filter conditions$")
	public void isNotifyMessageUnmarkedWithFlagPresents() {
		assertTrue(emailPage.isNotifyMessageUnmarkedWithFlagPresents());
	}
}
