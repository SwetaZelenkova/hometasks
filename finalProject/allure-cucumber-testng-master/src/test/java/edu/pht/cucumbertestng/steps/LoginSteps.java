package edu.pht.cucumbertestng.steps;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import edu.pht.cucumbertestng.beans.User;
import edu.pht.cucumbertestng.pages.LoginPage;
import edu.pht.cucumbertestng.utils.Driver;
import edu.pht.cucumbertestng.utils.UserSimpleBuilder;
import cucumber.api.java.en.Then;

public class LoginSteps {

	private static final Logger logger = Logger.getLogger(LoginSteps.class);
	public static final String URL_TO_WEB_APP = "https://mail.ru";
	public static final String LOGIN = "zelenkova-sveta";
	public static final String DOMAIN = "@bk.ru";
	public static final String PASSWORD = "Benz2503";

	private WebDriver driver;
	private LoginPage loginPage;

	public LoginSteps() {
		driver = Driver.getInstance();
		loginPage = new LoginPage(driver);
		logger.info("LoginPage initialization finished.....");
	}

	@Before(order = 0)
	public void beforeScenarioStart() {
		logger.info("-----------------Start of Scenario-----------------");
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		driver.get(URL_TO_WEB_APP);
		logger.info("Go to web application with url: " + URL_TO_WEB_APP);
	}

	@When("^I login as correct user$")
	public void loginAsCorrectUser() {
		User user = new UserSimpleBuilder().build();
		loginPage.enterLoginAndPass(user.getLogin(), user.getDomain(), user.getPassword());
		loginPage.makeScreenshot();
		loginPage.clickEnterButton();
		logger.info("Authentication with login: " + LOGIN + ", pass: " + PASSWORD + " and domain: " + DOMAIN);
	}

	@When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void loginAsUserWithCredentials(String name, String domain, String password) {
		loginPage.enterLoginAndPass(name, domain, password);
		loginPage.makeScreenshot();
		loginPage.clickEnterButton();
		logger.info("Authentication with login: " + name + ", pass: " + password + " and domain: " + domain);
	}

	@Then("I see error message")
	public void seeErrorMessage() {
		assertTrue(loginPage.isMessageErrorPresents());
		logger.info("Incorrect login or pass is confirmed with message " + LoginPage.INCORRECT_NAME_OR_PASSWORD);
	}

	@When("^The icons are present in the DOM and are displayed on the page$")
	public void countAllIcons() {
		assertTrue(loginPage.countAllIcons());
		logger.info("All 7 Icons are in the DOM.....");
	}

	@Then("^I see all icons$")
	public void arePresentAndDisplayedAllIcons() {
		assertTrue(loginPage.arePresentAndDisplayedAllIcons());
		logger.info("All Icons are present in the DOM and are displayed on the page.....");
	}

	@After(order = 1)
	public void afterClass() {
		loginPage.makeScreenshot();
		Driver.killInstance();
	}

	@After(order = 0)
	public void afterScenarioFinish() {
		logger.info("-----------------End of Scenario-----------------");
	}
}
