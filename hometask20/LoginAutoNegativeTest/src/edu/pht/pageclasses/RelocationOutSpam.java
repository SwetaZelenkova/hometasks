package edu.pht.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RelocationOutSpam extends Driver {

	private final String xpathSpamEnter = "//div[@data-id='950']/a";
	private final String xpathCheckbox = "(//div[@class='b-datalist__body']/div[1]/div/a/div[1]//div/div[1])[2]";//"//*[@id='b-letters']/div/div[5]/div/div[2]/div[1]/div/a/div[1]/div/div[1]";
	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(xpath = xpathSpamEnter)
	private WebElement spamEnter;

	@FindBy(xpath = xpathCheckbox)
	private WebElement checkbox;

	@FindBy(xpath = "//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[3]")
	private WebElement notSpamEnter;

	@FindBy(xpath = "//*[@id='Notify']/div[1]/div/span")
	private WebElement notifyMessage;

	public RelocationOutSpam() {
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
				.presenceOfElementLocated(By.xpath(xpathSpamEnter)));
		spamEnter.click();
		getWait(100).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(xpathCheckbox)));
		checkbox.click();
		notSpamEnter.click();
	}

	public WebElement notifyMessagePresents() {
		return getWait(30).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//span[contains(., 'Письмо перемещено в папку')]")));
	}
}
