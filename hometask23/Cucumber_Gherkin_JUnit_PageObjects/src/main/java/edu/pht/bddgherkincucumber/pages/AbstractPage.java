package edu.pht.bddgherkincucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.pht.bddgherkincucumber.utils.Const;

public class AbstractPage {
	
	protected static final int WAIT = 70;
	protected static final int SHORT_WAIT = 30;

	protected WebDriver driver;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToMainAppPage() {
		driver.get(Const.URL_TO_WEB_APP);
	}

	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	protected WebElement waitUntilElementPresence(long time, String locator){		
		return (new WebDriverWait(driver, time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	protected boolean isDisplayedTextInElement(WebElement element, String text) {
		return (new WebDriverWait(driver, WAIT)).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	protected boolean waitUntilDisplayedElementContainsNotifyMessage(long time, String message) {
		return waitUntilElementPresence(time, ".//span[contains(., '" + message + "')]").isDisplayed();
	}
}
