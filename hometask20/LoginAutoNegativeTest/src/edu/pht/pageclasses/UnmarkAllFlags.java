package edu.pht.pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UnmarkAllFlags extends Driver {
	
	private final String xpathCheckboxes = "//div[@class='b-checkbox__box']";
	private final int startCheckEmails = 2;

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(xpath = "//*[@id='b-toolbar__right']/div[2]/div/div[1]/div[2]/div/div[2]")
	private WebElement filterEmailsWithFlags;
	
	@FindBy(xpath = xpathCheckboxes)
	private List<WebElement> checkboxes;
	
	@FindBy(xpath = "//div[@data-group='letters-more']")
	private WebElement dropdownMore;
	
	@FindBy(xpath = "//a[@data-text='Снять флажок']")
	private WebElement unmarkFlag;
	
	@FindBy(xpath = "//*[@id='b-letters']/div/div[2]/div/div[2]/div/div/div/div[2]/span")
	private WebElement notifyMessage;

	public UnmarkAllFlags() {
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

	public void filterEmailsWithFlags() {
		getWait(100).until(ExpectedConditions.visibilityOf(filterEmailsWithFlags));
		filterEmailsWithFlags.click();
	}
	
	public void checkEmails() {
		getWait(100).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathCheckboxes)));
		for (int i = startCheckEmails; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
	}
	
	public void unmarkFlag() {
		dropdownMore.click();
		unmarkFlag.click();
	}

	public Boolean checkMessageAfterUnmarkAllFlags() {
		return isDisplayedTextInElement(notifyMessage, "Нет писем, попадающих под условия фильтра.");
	}

	private boolean isDisplayedTextInElement(WebElement element, String text) {
		return getWait(100).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
}