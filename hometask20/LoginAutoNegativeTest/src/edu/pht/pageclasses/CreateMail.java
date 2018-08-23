package edu.pht.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateMail extends Driver {

	private final String xpathButtonCreate = "(//a[@title='Написать письмо (N)'])[1]";
	private final String xpathTextareaReceiver = "(//*[@tabindex='4'])[2]";
	private WebDriver driver;

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonEnter;

	@FindBy(xpath = xpathButtonCreate)
	private WebElement buttonCreate;

	@FindBy(xpath = xpathTextareaReceiver)
	private WebElement textareaReceiver;

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

	public CreateMail() {
		driver = getDriver();
		PageFactory.initElements(driver, this);
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
		getWait(100).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathButtonCreate)));
		buttonCreate.click();
	}

	public void write(String emailAddresse, String thread, String text) {
		getWait(20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTextareaReceiver)));
		textareaReceiver.clear();
		textareaReceiver.sendKeys(emailAddresse);
		inputThread.clear();
		inputThread.sendKeys(thread);
		driver.switchTo().frame(iframe);
		textEmail.clear();
		textEmail.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	public void clickButtonSend() {
		buttonSend.click();
	}

	public boolean sentMessagePresents() {
		return isDisplayedTextInElement(divMessageSentTitle, "Ваше письмо отправлено. Перейти во Входящие");
	}

	private boolean isDisplayedTextInElement(WebElement element, String text) {
		return getWait(100).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
}
