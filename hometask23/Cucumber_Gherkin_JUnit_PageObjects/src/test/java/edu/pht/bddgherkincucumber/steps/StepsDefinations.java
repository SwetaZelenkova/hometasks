package edu.pht.bddgherkincucumber.steps;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.pht.bddgherkincucumber.pages.CreateMailPage;
import edu.pht.bddgherkincucumber.pages.EmailPage;
import edu.pht.bddgherkincucumber.pages.LoginPage;
import edu.pht.bddgherkincucumber.pages.RecycleBinPage;
import edu.pht.bddgherkincucumber.pages.SpamPage;
import edu.pht.bddgherkincucumber.utils.Const;

public class StepsDefinations {
	
	private static final String FILE_WITH_DRIVER_PARAMS = "setDriverProperties.properties";

	private WebDriver driver;
	private LoginPage loginPage;
	private EmailPage emailPage;
	private RecycleBinPage recycleBinPage;
	private CreateMailPage createMailPage;
	private SpamPage spamPage;

	public StepsDefinations() {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(FILE_WITH_DRIVER_PARAMS));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String exePath = props.getProperty("PATH_TO_DRIVER");
		System.setProperty(props.getProperty("NAME_OF_DRIVER"), exePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty("IMPLICITLY_WAIT")), TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		emailPage = new EmailPage(driver);
		recycleBinPage = new RecycleBinPage(driver);
		createMailPage = new CreateMailPage(driver);
		spamPage = new SpamPage(driver);
	}

	@Given("^I am on main application page$")
	public void loadMainAppPage() {
		loginPage.goToMainAppPage();
	}

	@When("^I login as correct user$")
	public void loginAsCorrectUser() {
		loginPage.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
		loginPage.clickEnterButton();
	}

	@Then("^I see logout link$")
	public void isLogoutLinkPresents() {
		assertTrue(emailPage.isLogoutLinkPresents());
	}

	@And("^I logout$")
	public void logout() {
		emailPage.logout();
	}

	@When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void loginAsUserWithCredentials(String name, String domain, String password) {
		loginPage.enterLoginAndPass(name, domain, password);
		loginPage.clickEnterButton();
	}

	@Then("I see error message")
	public void isMessageErrorPresents() {
		assertTrue(loginPage.isMessageErrorPresents());
	}
	
	@And("^I choose the first letter$")
	public void checkMail() {
		emailPage.checkMail();
	}
	
	@And("^I click on the button delete$")
	public void clickButtonDelete() {
		emailPage.clickDeleteButton();
	}
	
	@Then("^I see message Your email has been deleted$")
	public void isNotifyDeleteMailPresents() {
		assertTrue(emailPage.isNotifyDeleteMailPresents());
	}
	
	@And("^I click on the link recycle bin$")
	public void moveToRecycleBin() {
		emailPage.moveToRecycleBin();
	}
	
	@And("^I click on the button clean all$")
	public void clickButtonCleanRecycleBin() {
		recycleBinPage.cleanRecycleBin();
	}
	
	@And("^I click on the button for confirm$")
	public void confirmCleanRecycleBin() {
		recycleBinPage.confirmCleanRecycleBin();
	}
	
	@Then("^I see message your recycle bin is empty$")
	public void isNotifyEmptyRecycleBinPresents() {
		assertTrue(recycleBinPage.isNotifyCleanRecycleBinPresents());
	}
	
	@When("^The icons are present in the DOM and are displayed on the page$")
	public void countAllIcons() {
		assertTrue(loginPage.countAllIcons());
	}
	
	@Then("^I see all icons$")
	public void arePresentAndDisplayedAllIcons() {
		assertTrue(loginPage.arePresentAndDisplayedAllIcons());
	}
	
	@And("^I click on the button create mail$")
	public void clickButtonCreateMail() {
		emailPage.createMail();
	}
	
	@And("^I enter the recipients email address$")
	public void enterEmailAddress() {
		createMailPage.enterRecipientsEmailAddress(Const.RECIPIENTS_EMAIL_ADDRESS);
	}
	
	@And("^I enter more recipients email addresses$")
	public void enterMoreEmailAddresses() {
		createMailPage.enterMoreEmailAddresses(Const.RECIPIENTS_EMAIL_ADDRESS, "lana_zelenkova@tut.by", "nika.benz@tut.by");
	}
	
	@And("^I enter the subject of the email$")
	public void enterSubjectOfEmail() {
		createMailPage.enterSubjectOfEmail(Const.SUBJECT_OF_EMAIL);
	}
	
	@And("^I enter the body of the email$")
	public void enterBodyOfEmail() {
		createMailPage.enterBodyOfEmail(Const.TEXT_OF_EMAIL);
	}
	
	@And("^I click on the button send mail$")
	public void clickButtonSendMail() {
		createMailPage.clickButtonSendMail();
	}
	
	@Then("^I see message Your letter has been sent$")
	public void isSentMessagePresents() {
		assertTrue(createMailPage.isSentMessagePresents());
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
	
	@And("^I click on the link to spam folder$")
	public void clickLinkToSpamFolder() {
		emailPage.goSpamFolder();
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
	
	@And("^I choose the three emails$")
	public void checkEmailsToMark() {
		emailPage.checkEmailsToMark();
	}
	
	@And("^I click on the button more actions$")
	public void clickButtonMoreActions() {
		emailPage.clickButtonMoreActions();
	}

	@And("^I click the flag link$")
	public void clickLink() {
		emailPage.markFlag();
	}
	
	@Then("^I see message Your emails has been marked with flag$")
	public void isNotifyMessageMarkedWithFlagPresents() {
		assertTrue(emailPage.isNotifyMessageMarkedWithFlagPresents());
	}
	
	@After
	public void afterClass() {
		loginPage.closeDriver();
	}
}
