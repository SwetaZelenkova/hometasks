package edu.pht.cucumbertestng.steps;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumbertestng.pages.RecycleBinPage;
import edu.pht.cucumbertestng.utils.Driver;

public class RecycleBinSteps {

	private static final Logger logger = Logger.getLogger(RecycleBinSteps.class);
	private WebDriver driver;
	private RecycleBinPage recycleBinPage;

	public RecycleBinSteps() {
		logger.info("RecycleBin tests are starting.....");
		driver = Driver.getInstance();
		recycleBinPage = new RecycleBinPage(driver);
		logger.info("RecycleBinPage initialization finished.....");
	}

	@And("^I click on the button clean all$")
	public void cleanRecycleBin() {
		recycleBinPage.cleanRecycleBin();
		recycleBinPage.makeScreenshot();
		logger.info("Clean out.....");
	}

	@And("^I click on the button for confirm$")
	public void confirm() {
		recycleBinPage.confirmCleanRecycleBin();
		logger.info("Cleaning of the recycle bin is confirmed.....");
	}

	@Then("^I see message your recycle bin is empty")
	public void isNotifyMessagePresent() {
		assertTrue(recycleBinPage.isNotifyMessageCleanRecycleBinPresents());
		logger.info("Cleaning of the recycle bin is confirmed with message 'В Корзине пусто.'.....");
	}
}
