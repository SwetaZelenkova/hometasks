package edu.pht.pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends Driver {
	
	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(id = "PH_logoutLink")
	private WebElement logoutLink;

	@FindBy(id = "mailbox:error")
	private WebElement errorMessage;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterLoginAndPass(String login, 
								  String domain, 
								  String password) {
		getWait(100).until(ExpectedConditions.visibilityOf(loginField));
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

	public boolean logoutLinkPresents() {
		return getWait(100).until(ExpectedConditions
				.visibilityOf(logoutLink))
				.isDisplayed();
	}

	public Boolean errorMessagePresents() {
		return getWait(100).
				until(ExpectedConditions.
						textToBePresentInElement(errorMessage, 
								"Неверное имя или пароль"));
	}
}