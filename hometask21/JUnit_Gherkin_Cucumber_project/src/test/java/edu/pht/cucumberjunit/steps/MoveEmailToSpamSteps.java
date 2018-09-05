package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;

public class MoveEmailToSpamSteps {

	private WebDriver driver;
	private EmailPage emailPage;

	public MoveEmailToSpamSteps() {
		driver = Driver.getInstance();
		emailPage = new EmailPage(driver);
	}

	@And("^I click on the button move to$")
	public void clickMoveTo() {
		emailPage.clickMoveTo();
	}

	@And("^I click on the link spam$")
	public void clickSpamLink() {
		emailPage.clickSpamLink();
	}

	@Then("^I see message Your email has been moved to spam$")
	public void isMovedToSpam() {
		assertTrue(emailPage.isToSpam());
	}
}
