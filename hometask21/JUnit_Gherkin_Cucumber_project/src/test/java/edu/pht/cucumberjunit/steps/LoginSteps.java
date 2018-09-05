package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;
import edu.pht.cucumberjunit.LoginPage;
import cucumber.api.java.en.Then;

public class LoginSteps {

	public static final String URL_TO_WEB_APP = "https://mail.ru";
	public static final String LOGIN = "zelenkova-sveta";
	public static final String DOMAIN = "@bk.ru";
	public static final String PASSWORD = "Benz2503";

	private WebDriver driver;
	private LoginPage loginPage;
	private EmailPage emailPage;

	public LoginSteps() {
		driver = Driver.getInstance();
		loginPage = new LoginPage(driver);
		emailPage = new EmailPage(driver);
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		driver.get(URL_TO_WEB_APP);
	}

	@When("^I login as correct user$")
	public void loginAsCorrectUser() {
		loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
		loginPage.clickEnterButton();
	}

	@When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void loginAsUserWithCredentials(String name, String domain, String password) {
		loginPage.enterLoginAndPass(name, domain, password);
		loginPage.clickEnterButton();
	}

	@Then("I see error message")
	public void seeErrorMessage() {
		assertTrue(loginPage.isMessageErrorPresents());
	}

	@Then("^I see logout link$")
	public void seeLogoutLink() {
		assertTrue(emailPage.isLogoutLinkPresents());
	}

	@And("^I logout$")
	public void logout() {
		emailPage.logout();
	}

	@After
	public void afterClass() {
		Driver.killInstance();
	}
}
