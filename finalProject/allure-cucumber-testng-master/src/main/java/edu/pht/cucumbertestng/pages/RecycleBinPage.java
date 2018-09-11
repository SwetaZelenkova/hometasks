package edu.pht.cucumbertestng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecycleBinPage extends AbstractPage {

	private static final String RECYCLE_BIN_IS_EMPTY = "В Корзине пусто.";
	private final String xpathCleanButton = "//button[@data-name='clearFolder']";

	@FindBy(xpath = xpathCleanButton)
	private WebElement cleanButton;

	@FindBy(xpath = "//button[@class='btn btn_stylish confirm-ok']")
	private WebElement confirmButton;

	@FindBy(xpath = "(//span[text()='" + RECYCLE_BIN_IS_EMPTY + "'])[1]")
	private WebElement notifyMessage;

	public RecycleBinPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void cleanRecycleBin() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathCleanButton);
		cleanButton.click();
	}

	public void confirmCleanRecycleBin() {
		confirmButton.click();
	}

	public boolean isNotifyMessageCleanRecycleBinPresents() {
		return waitUntilDisplayedTextInElement(notifyMessage, RECYCLE_BIN_IS_EMPTY);
	}
}
