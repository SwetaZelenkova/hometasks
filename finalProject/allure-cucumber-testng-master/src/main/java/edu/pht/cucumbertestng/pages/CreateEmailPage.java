package edu.pht.cucumbertestng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEmailPage extends AbstractPage {

	public static final String EMAIL_SENT = "Ваше письмо отправлено. Перейти во Входящие";
	private final String xpathReceiverTextarea = "(//*[@tabindex='4'])[2]";

	@FindBy(xpath = xpathReceiverTextarea)
	private WebElement receiverTextarea;

	@FindBy(xpath = "//*[@name='Subject']")
	private WebElement threadInput;

	@FindBy(xpath = "//*[@id='tinymce']")
	private WebElement textEmail;

	@FindBy(xpath = "(//*[@data-name='send'])[1]")
	private WebElement sendMailButton;

	@FindBy(xpath = "//*[@id='b-compose__sent']/div/div[1]/div")
	private WebElement messageSentTitleDiv;

	@FindBy(xpath = "//td[@class='mceIframeContainer mceFirst mceLast']/iframe")
	public WebElement iframe;

	@FindBy(xpath = "//*[@tabindex='5']")
	private WebElement copyForReceivers;

	public CreateEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterRecipientsEmailAddress(String emailAddress) {
		waitUntilElementPresence(SHORT_TIME_OUT, xpathReceiverTextarea);
		receiverTextarea.clear();
		receiverTextarea.sendKeys(emailAddress);
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
		threadInput.clear();
		threadInput.sendKeys(thread);
	}

	public void enterBodyOfEmail(String text) {
		driver.switchTo().frame(iframe);
		textEmail.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	public void clickButtonSendEmail() {
		sendMailButton.click();
	}

	public boolean isMessageSentEmailPresents() {
		return waitUntilDisplayedTextInElement(messageSentTitleDiv, EMAIL_SENT);
	}
}
