package edu.pht.cucumbertestng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;

public abstract class AbstractPage {

	protected static final int DEFAULT_TIME_OUT = 10;
	protected static final int STANDARD_TIME_OUT = 100;
	protected static final int SHORT_TIME_OUT = 30;

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement waitUntilElementPresence(long time, String locator) {
		return (new WebDriverWait(driver, time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	protected boolean waitUntilDisplayedTextInElement(WebElement element, String text) {
		return (new WebDriverWait(driver, STANDARD_TIME_OUT))
				.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	protected boolean waitUntilElementIsVisibility(WebElement element) {
		return (new WebDriverWait(driver, STANDARD_TIME_OUT)).until(ExpectedConditions.visibilityOf(element))
				.isDisplayed();
	}

	protected boolean waitUntilDisplayedElementContainsNotifyMessage(long time, String message) {
		return waitUntilElementPresence(time, ".//span[contains(., '" + message + "')]").isDisplayed();
	}
	
	@Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
