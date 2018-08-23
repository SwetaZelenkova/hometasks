package edu.pht.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SendMailToGroupRecivers extends Driver {

	private final String xpathButton = "//*[@id='b-toolbar__left']/div/div/div[2]/div/a";
	
	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(xpath = xpathButton)
	private WebElement buttonCreate;

	@FindBy(xpath = "(//*[@tabindex='4'])[2]")
	private WebElement textareaReceiver;

	@FindBy(xpath = "//*[@tabindex='5']")
	private WebElement copyForReceivers;

	@FindBy(xpath = "//*[@name='Subject']")
	private WebElement inputThread;

	@FindBy(xpath = "//*[@id='tinymce']")
	private WebElement textEmail;

	@FindBy(xpath = "(//*[@data-name='send'])[1]")
	private WebElement buttonSend;

	@FindBy(xpath = "//*[@id='b-compose__sent']/div/div[1]/div")
	private WebElement divMessageSentTitle;

	@FindBy(xpath = "//td[@class='mceIframeContainer mceFirst mceLast']/iframe")
	public WebElement iframe;

	public SendMailToGroupRecivers() {
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
	
	public void create() {
		getWait(100).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathButton)));
		buttonCreate.click();
	}

	public void write(String emailAddresse, String thread, String text, String... emailAddresses) {
		textareaReceiver.clear();
		textareaReceiver.sendKeys(emailAddresse);
		copyForReceivers.clear();
		String emails = "";
		for (int i = 0; i < emailAddresses.length; i++) {
			emails += emailAddresses[i] + " ";
		}
		copyForReceivers.sendKeys(emails);
		inputThread.clear();
		inputThread.sendKeys(thread);
		getDriver().switchTo().frame(iframe);
		textEmail.sendKeys(text);
		getDriver().switchTo().defaultContent();
	}

	public void clickButtonSend() {
		buttonSend.click();
	}

	public Boolean sentMessagePresents() {
		return isDisplayedTextInElement(divMessageSentTitle, "Ваше письмо отправлено. Перейти во Входящие");
	}

	private boolean isDisplayedTextInElement(WebElement element, String text) {
		return getWait(100).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
}
