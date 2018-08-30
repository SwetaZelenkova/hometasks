package edu.pht.bddgherkincucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecycleBinPage extends AbstractPage {
	
	public static final String RECYCLE_BIN_IS_EMPTY = "В Корзине пусто.";

	private final String xpathCleanButton = "//button[@data-name='clearFolder']";

	@FindBy(xpath = xpathCleanButton)
	private WebElement cleanButton;

	@FindBy(xpath = "(//*[@class='btn__text'])[10]")
	private WebElement confirmButton;

	@FindBy(xpath = "(//span[text()='" + RECYCLE_BIN_IS_EMPTY + "'])[1]")
	private WebElement notifyMessage;

	public RecycleBinPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void cleanRecycleBin() {
		waitUntilElementPresence(WAIT, xpathCleanButton);
		cleanButton.click();
	}

	public void confirmCleanRecycleBin() {
		confirmButton.click();
	}

	public boolean isNotifyCleanRecycleBinPresents() {
		return isDisplayedTextInElement(notifyMessage, RECYCLE_BIN_IS_EMPTY);
	}
}
