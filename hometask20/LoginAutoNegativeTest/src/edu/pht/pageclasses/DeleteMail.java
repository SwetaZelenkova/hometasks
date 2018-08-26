package edu.pht.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DeleteMail extends Driver {
	private final String xpathCheckbox = "//*[@id='b-letters']/div[1]/div[2]/div/div[2]/div[1]/div/a/div[1]/div/div[1]";

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(xpath = xpathCheckbox)
	private WebElement checkbox;

	@FindBy(xpath = "//*[@id='b-toolbar__right']/div[2]/div/div[2]/div[2]/div/div[1]")
	private WebElement deleteButton;

	@FindBy(xpath = "//*[@id='Notify']/div[1]/div/span")
	private WebElement notifyMessage;

	public DeleteMail() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterLoginAndPass(String login, 
			                      String domain, 
			                      String password) {
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

	public void delete() {
		getWait(100).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(xpathCheckbox)));
		checkbox.click();
		deleteButton.click();
	}

	public WebElement notifyMessagePresents() {
		return getWait(100).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//span[contains(., 'Удалено 1 письмо.')]")));
	}
}
