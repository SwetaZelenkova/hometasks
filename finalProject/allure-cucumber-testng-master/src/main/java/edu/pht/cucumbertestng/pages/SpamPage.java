package edu.pht.cucumbertestng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage extends AbstractPage {

	private static final String EMAIL_MOVED_FROM_SPAM = "Письмо перемещено в папку «Входящие»";
	private final String xpathCheckbox = "(//div[@class='b-datalist__body']/div[1]/div/a/div[1]//div/div[1])[2]";// "//*[@id='b-letters']/div/div[5]/div/div[2]/div[1]/div/a/div[1]/div/div[1]";

	@FindBy(xpath = xpathCheckbox)
	private WebElement checkbox;

	@FindBy(xpath = "//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[3]")
	private WebElement notSpamButton;

	@FindBy(xpath = "//*[@id='Notify']/div[1]/div/span")
	private WebElement notifyMessage;

	public SpamPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void checkMail() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathCheckbox);
		checkbox.click();
	}

	public void goOutSpam() {
		notSpamButton.click();
	}

	public boolean isNotifyMessageNotSpamPresents() {
		return waitUntilDisplayedElementContainsNotifyMessage(SHORT_TIME_OUT, EMAIL_MOVED_FROM_SPAM);
	}
}
