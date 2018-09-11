package edu.pht.cucumbertestng.steps;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumbertestng.pages.SpamPage;
import edu.pht.cucumbertestng.utils.Driver;

public class SpamSteps {

	private static final Logger logger = Logger.getLogger(SpamSteps.class);
	private WebDriver driver;
	private SpamPage spamPage;

	public SpamSteps() {
		logger.info("Spam tests are starting.....");
		driver = Driver.getInstance();
		spamPage = new SpamPage(driver);
		logger.info("SpamPage initialization finished.....");
	}

	@And("^I choose the first email in spam folder$")
	public void checkMailInSpamFolder() {
		spamPage.checkMail();
		logger.info("Check first email.....");
	}

	@And("^I click on the button not spam$")
	public void clickButtonNotSpam() {
		spamPage.goOutSpam();
		logger.info("Email is marked as not spam.....");
	}

	@Then("^I see message Your email has been moved from spam$")
	public void isNotifyMessageNotSpamPresents() {
		assertTrue(spamPage.isNotifyMessageNotSpamPresents());
		logger.info("Email moving is confirmed with message 'Письмо перемещено в папку «Входящие»'.....");
	}
}
