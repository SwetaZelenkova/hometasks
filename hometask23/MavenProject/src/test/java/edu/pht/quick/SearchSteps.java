package edu.pht.quick;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {

	private static final String MAIN_URL = "http://mail.ru";
	private static final String CHROMEDRIVER_EXE = "D:\\SeleniumDriver\\chromedriver.exe";
	private SearchPage searchPage;
	private WebDriver webDriver;

	public SearchSteps() {
		String exePath = CHROMEDRIVER_EXE;
		System.setProperty("webdriver.chrome.driver", exePath);
		webDriver = new ChromeDriver();
		searchPage = new SearchPage(webDriver);
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		webDriver.get(MAIN_URL);
	}

	@When("^I enter in search field \"([^\"]*)\"$")
	public void enterQueryInSearchField(String query) {
		(new WebDriverWait(webDriver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='q']")));
		searchPage.enterQueryInSearchField(query);
	}

	@And("^I click on a button to search$")
	public void clickSearchButton() {
		searchPage.clickSearchButton();
	}

	@Then("^I see on the page list of links with results \"([^\"]*)\"$")
	public void seeListOfLinks(String query) {
		(new WebDriverWait(webDriver, 100))
				.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id='js-result_1']/h3/a"))));
		boolean actual = true;
		List<WebElement> elementsWithResult = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			elementsWithResult.add(webDriver.findElement(By.xpath("//*[@id='js-result_" + (i + 1) + "']/h3/a")));
			System.out.println(elementsWithResult.get(i).getText());
			if (elementsWithResult.get(i).getText().toLowerCase().contains(query.toLowerCase())) {
				System.out.println("true");
				actual &= true;
			} else {
				System.out.println("false");
				actual &= false;
			}
		}
		Assert.assertTrue(actual);
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}
}
