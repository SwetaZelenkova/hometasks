package edu.pht.pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectThreeEmails extends Driver {
	
	private final String xpathCheckboxes = "//div[@class='b-checkbox__box']";
	private final int countEmailsToCheck = 3;
	private final int startCheckEmails = 2;

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;
	
	@FindBy(xpath = xpathCheckboxes)
	private List<WebElement> checkboxes;
	
	@FindBy(xpath = "//div[@data-group='letters-more']")
	private WebElement dropdownMore;
	
	@FindBy(xpath = "//a[@data-text='Пометить флажком']")
	private WebElement flagYes;
	
	@FindBy(xpath = "//*[@id='Notify']/div[1]/div/span")
	private WebElement notifyMessage;
	
	public SelectThreeEmails() {
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
	
	public void checkEmails() {
		getWait(100).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathCheckboxes)));
		for (int i = startCheckEmails; i < startCheckEmails + countEmailsToCheck; i++) {
			checkboxes.get(i).click();
		}
	}
	
	public void markFlag() {
		dropdownMore.click();
		flagYes.click();
	}
	
	public WebElement notifyMessagePresents() {
		return getWait(30).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//span[contains(., 'Помечено 3 письма.')]")));
	}
}
