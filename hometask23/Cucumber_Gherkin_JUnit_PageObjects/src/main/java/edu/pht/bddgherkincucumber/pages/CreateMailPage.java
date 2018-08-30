package edu.pht.bddgherkincucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMailPage extends AbstractPage {
	
	public static final String EMAIL_SENT = "Ваше письмо отправлено. Перейти во Входящие";
	private final String xpathTextareaReceiver = "(//*[@tabindex='4'])[2]";
	
	@FindBy(xpath = xpathTextareaReceiver)
	private WebElement textareaReceiver;

	@FindBy(xpath = "//*[@name='Subject']")
	private WebElement inputThreadMail;

	@FindBy(xpath = "//*[@id='tinymce']")
	private WebElement textEmail;

	@FindBy(xpath = "(//*[@data-name='send'])[1]")
	private WebElement buttonSendMail;

	@FindBy(xpath = "//*[@id='b-compose__sent']/div/div[1]/div")
	private WebElement divMessageSentTitle;

	@FindBy(xpath = "//td[@class='mceIframeContainer mceFirst mceLast']/iframe")
	public WebElement iframe;
	
	@FindBy(xpath = "//*[@tabindex='5']")
	private WebElement copyForReceivers;

	public CreateMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterRecipientsEmailAddress(String emailAddresse) {
		waitUntilElementPresence(SHORT_WAIT, xpathTextareaReceiver);
		textareaReceiver.clear();
		textareaReceiver.sendKeys(emailAddresse);
	}
	
	public void enterMoreEmailAddresses(String... emailAddresses) {
		copyForReceivers.clear();
		String emails = "";
		for (int i = 0; i < emailAddresses.length; i++) {
			emails += emailAddresses[i] + " ";
		}
		copyForReceivers.sendKeys(emails);
	}
	
	public void enterSubjectOfEmail(String thread) {
		inputThreadMail.clear();
		inputThreadMail.sendKeys(thread);
	}
	
	public void enterBodyOfEmail(String text) {
		driver.switchTo().frame(iframe);
		textEmail.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	public void clickButtonSendMail() {
		buttonSendMail.click();
	}

	public boolean isSentMessagePresents() {
		return isDisplayedTextInElement(divMessageSentTitle, EMAIL_SENT);
	}
}
