package edu.pht.cucumbertestng.steps;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumbertestng.pages.EmailPage;
import edu.pht.cucumbertestng.utils.Driver;

public class EmailPageSteps {

	private static final Logger logger = Logger.getLogger(EmailPageSteps.class);
	private WebDriver driver;
	private EmailPage emailPage;

	public EmailPageSteps() {
		logger.info("Tests are starting.....");
		driver = Driver.getInstance();
		emailPage = new EmailPage(driver);
		logger.info("EmailPage initialization finished.....");
	}

	@And("^I click on the button create mail$")
	public void clickButtonCreateMail() {
		emailPage.createMail();
		logger.info("Email is creating.....");
	}

	@And("^I choose the first letter$")
	public void checkMailToDelete() {
		emailPage.checkMailToDelete();
		emailPage.makeScreenshot();
		logger.info("Email is marked for deletion.....");
	}

	@And("^I click on the button delete$")
	public void delete() {
		emailPage.clickDeleteButton();
		logger.info("Email is deleting.....");
	}

	@Then("^I see message Your email has been deleted$")
	public void notifyMessagePresents() {
		assertTrue(emailPage.isNotifyMessageDeleteEmailPresents());
		logger.info("Emails deletion is confirmed with message 'Удалено 1 письмо.'");
	}

	@And("^I click on the link to spam folder$")
	public void clickLinkToSpamFolder() {
		emailPage.goToSpamFolder();
		logger.info("Go from EmailPage to SpamPage.....");
	}

	@And("^I click on the button move to$")
	public void clickMoveTo() {
		emailPage.clickMoveTo();
		logger.info("Email is moved to SpamPage.....");
	}

	@And("^I click on the link spam$")
	public void clickSpamLink() {
		emailPage.clickSpamLink();
		emailPage.makeScreenshot();
		logger.info("Email is marked as spam.....");
	}

	@Then("^I see message Your email has been moved to spam$")
	public void isMovedToSpam() {
		assertTrue(emailPage.isToSpam());
		logger.info("Move to spam is confirmed with message 'Письмо перемещено в папку «Спам»'");
	}

	@And("^I click on the link recycle bin$")
	public void goToRecycleBin() {
		emailPage.goToRecycleBin();
		logger.info("Go from EmailPage to RecycleBinPage.....");
	}

	@And("^I choose the three emails$")
	public void checkEmailsToMark() {
		emailPage.checkEmailsToMark();
		emailPage.makeScreenshot();
		logger.info("Check the three emails.....");
	}

	@And("^I click on the button more actions$")
	public void clickButtonMoreActions() {
		emailPage.clickButtonMoreActions();
		logger.info("Check the more actions.....");
	}

	@And("^I click the flag link$")
	public void clickMarkFlagLink() {
		emailPage.markFlag();
		emailPage.makeScreenshot();
		logger.info("Check the flag.....");
	}

	@Then("^I see message Your emails has been marked with flag$")
	public void isNotifyMessageMarkedWithFlagPresents() {
		assertTrue(emailPage.isNotifyMessageMarkedWithFlagPresents());
		logger.info("Marked with flag is confirmed with message 'Помечено 3 письма'.....");
	}

	@And("^I click on the button filter the emails marked with a check mark$")
	public void clickButtonToFilterEmails() {
		emailPage.filterEmailsWithFlags();
		emailPage.makeScreenshot();
		logger.info("Filter the emails marked with a flag.....");
	}

	@And("^I choose all emails$")
	public void checkEmailsToUnmark() {
		emailPage.checkEmailsToUnmark();
		emailPage.makeScreenshot();
		logger.info("Check all emails.....");
	}

	@And("^I click on the uncheck the flag link$")
	public void clickUnmarkFlagLink() {
		emailPage.checkEmailsToUnmark();
		emailPage.makeScreenshot();
		logger.info("Uncheck the flag.....");
	}

	@Then("^I see message no emails that fall under the filter conditions$")
	public void isNotifyMessageUnmarkedWithFlagPresents() {
		assertTrue(emailPage.isNotifyMessageUnmarkedWithFlagPresents());
		logger.info("Ucheck the flag is confirmed with message 'Нет писем, попадающих под условия фильтра.'.....");
	}

	@Then("^I see logout link$")
	public void seeLogoutLink() {
		assertTrue(emailPage.isLogoutLinkPresents());
		logger.info("Log out link is present");
	}

	@And("^I logout$")
	public void logout() {
		emailPage.logout();
		logger.info("Log out");
	}
}
