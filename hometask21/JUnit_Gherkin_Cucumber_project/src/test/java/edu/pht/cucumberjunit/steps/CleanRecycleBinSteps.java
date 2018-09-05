package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;
import edu.pht.cucumberjunit.RecycleBinPage;

public class CleanRecycleBinSteps {

	private WebDriver driver;
	private RecycleBinPage recycleBinPage;
	private EmailPage emailPage;

	public CleanRecycleBinSteps() {
		driver = Driver.getInstance();
		recycleBinPage = new RecycleBinPage(driver);
		emailPage = new EmailPage(driver);
	}

	@And("^I click on the link recycle bin$")
	public void goToRecycleBin() {
		emailPage.goToRecycleBin();
	}

	@And("^I click on the button clean all$")
	public void cleanRecycleBin() {
		recycleBinPage.cleanRecycleBin();
	}

	@And("^I click on the button for confirm$")
	public void confirm() {
		recycleBinPage.confirmCleanRecycleBin();
	}

	@Then("^I see message your recycle bin is empty")
	public void isNotifyMessagePresent() {
		assertTrue(recycleBinPage.isNotifyMessageCleanRecycleBinPresents());
	}
}
