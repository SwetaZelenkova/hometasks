package edu.pht.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CleanRecycleBin extends Driver {
	
	private final String xpathRecycleBin = "//*[@id='b-nav_folders']/div/div[5]/a";
	private final String xpathCleanButton = "//button[@data-name='clearFolder']";

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(xpath = xpathRecycleBin)
	private WebElement recycleBin;

	@FindBy(xpath = xpathCleanButton)
	private WebElement cleanButton;

	@FindBy(xpath = "(//*[@class='btn__text'])[10]")
	private WebElement confirmButton;

	@FindBy(xpath = "(//span[text()='В Корзине пусто.'])[1]")
	private WebElement notifyMessage;

	public CleanRecycleBin() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterLoginAndPass(String login, String domain, String password) {
		loginField.clear();
		loginField.sendKeys(login);
		Select select = new Select(domainDropdown);
		select.selectByVisibleText(domain);
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickEnterButton() {
		buttonEnter.click();
	}

	public void clean() {
		getWait(100)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathRecycleBin)));
		recycleBin.click();
		getWait(100)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathCleanButton)));
		cleanButton.click();
	}

	public void confirm() {
		confirmButton.click();
	}

	public Boolean notifyMessagePresents() {
		return getWait(100)
				.until(ExpectedConditions.textToBePresentInElement(notifyMessage, "В Корзине пусто."));
	}
}
