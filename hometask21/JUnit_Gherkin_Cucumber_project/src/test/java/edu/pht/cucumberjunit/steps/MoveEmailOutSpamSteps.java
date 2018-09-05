package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;
import edu.pht.cucumberjunit.SpamPage;

public class MoveEmailOutSpamSteps {

	private WebDriver driver;
	private SpamPage spamPage;
	private EmailPage emailPage;

	public MoveEmailOutSpamSteps() {
		driver = Driver.getInstance();
		spamPage = new SpamPage(driver);
		emailPage = new EmailPage(driver);
	}

	@And("^I click on the link to spam folder$")
	public void clickLinkToSpamFolder() {
		emailPage.goToSpamFolder();
	}

	@And("^I choose the first email in spam folder$")
	public void checkMailInSpamFolder() {
		spamPage.checkMail();
	}

	@And("^I click on the button not spam$")
	public void clickButtonNotSpam() {
		spamPage.goOutSpam();
	}

	@Then("^I see message Your email has been moved from spam$")
	public void isNotifyMessageNotSpamPresents() {
		assertTrue(spamPage.isNotifyMessageNotSpamPresents());
	}
}
