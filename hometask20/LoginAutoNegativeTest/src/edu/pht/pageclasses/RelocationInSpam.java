package edu.pht.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RelocationInSpam extends Driver {

	private final String xpathCheckbox = "(//div[@class='b-checkbox__box'])[3]";
	private final String xpathSpamFolder = "//*[@id='b-nav_folders']/div/div[4]/a";

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(xpath = xpathSpamFolder)
	private WebElement spamFolder;

	@FindBy(xpath = xpathCheckbox)
	private WebElement checkbox;

	@FindBy(xpath = "//div[@title='Переместить (V)']")
	private WebElement moveTo;

	@FindBy(xpath = "//a[@data-text='Спам']")
	private WebElement spamButton;

	@FindBy(xpath = "//span[@data-id='950']/span")
	private WebElement notifyMessage;

	public RelocationInSpam() {
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

	public void relocate() {
		getWait(100).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(xpathCheckbox)));
		checkbox.click();
		moveTo.click();
		spamButton.click();
	}

	public boolean isToSpam() {
		return getWait(20).until(ExpectedConditions
				.textToBePresentInElement(notifyMessage, "очистить"));
	}
}
