package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;

public class DeleteEmailSteps {

	private WebDriver driver;
	private EmailPage emailPage;

	public DeleteEmailSteps() {
		driver = Driver.getInstance();
		emailPage = new EmailPage(driver);
	}

	@And("^I choose the first letter$")
	public void checkMailToDelete() {
		emailPage.checkMailToDelete();
	}

	@And("^I click on the button delete$")
	public void delete() {
		emailPage.clickDeleteButton();
	}

	@Then("^I see message Your email has been deleted$")
	public void notifyMessagePresents() {
		assertTrue(emailPage.isNotifyMessageDeleteEmailPresents());
	}
}
