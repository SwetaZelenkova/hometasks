package edu.pht.cucumbertestng.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage extends AbstractPage {

	private static final String EMAIL_DELETED = "Удалено 1 письмо.";
	public static final String EMAIL_MOVED_TO_SPAM = "Письмо перемещено в папку «Спам»";
	public static final String EMAIL_MARKED = "Помечено 3 письма";
	public static final String NO_EMAILS_UNDER_THE_FILTER_CONDITION = "Нет писем, попадающих под условия фильтра.";
	private final String xpathCheckbox = "//*[@id='b-letters']/div[1]/div[2]/div/div[2]/div[1]/div/a/div[1]/div/div[1]";
	private final String xpathCreateEmailButton = "(//a[@title='Написать письмо (N)'])[1]";
	private final String xpathSpamFolder = "//*[@id='b-nav_folders']/div/div[4]/a";
	// private final String xpathSpamFolder = "//div[@data-id='950']/a";
	private final String xpathCheckboxes = "//div[@class='b-checkbox__box']";
	private final int countEmailsToCheck = 3;
	private final int startCheckEmails = 2;
	private final String xpathFilterEmailsWithFlags = "//*[@id='b-toolbar__right']/div[2]/div/div[1]/div[2]/div/div[2]";
	private final String xpathRecycleBinLink = "//*[@id='b-nav_folders']/div/div[5]/a";

	@FindBy(xpath = xpathCheckbox)
	private WebElement checkbox;

	@FindBy(xpath = "//*[@id='b-toolbar__right']/div[2]/div/div[2]/div[2]/div/div[1]")
	private WebElement deleteButton;

	@FindBy(xpath = xpathCreateEmailButton)
	private WebElement createEmailButton;

	@FindBy(xpath = xpathSpamFolder)
	private WebElement spamFolder;

	@FindBy(xpath = "//div[@title='Переместить (V)']")
	private WebElement moveTo;

	@FindBy(xpath = "//a[@data-text='Спам']")
	private WebElement spamButton;

	@FindBy(xpath = "//span[@data-id='950']/span")
	private WebElement notifyMoveToSpamMessage;

	@FindBy(xpath = xpathCheckboxes)
	private List<WebElement> checkboxes;

	@FindBy(xpath = "//div[@data-group='letters-more']")
	private WebElement dropdownMore;

	@FindBy(xpath = "//a[@data-text='Пометить флажком']")
	private WebElement flagYes;

	@FindBy(xpath = xpathFilterEmailsWithFlags)
	private WebElement filterEmailsWithFlags;

	@FindBy(xpath = "//a[@data-text='Снять флажок']")
	private WebElement unmarkFlag;

	@FindBy(xpath = xpathRecycleBinLink)
	private WebElement recycleBinLink;

	@FindBy(xpath = "//*[@id='Notify']/div[1]/div/span")
	private WebElement notifyMessage;

	@FindBy(xpath = "//*[@id='PH_logoutLink']")
	private WebElement logoutLink;

	public EmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void checkMailToDelete() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathCheckbox);
		checkbox.click();
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

	public boolean isNotifyMessageDeleteEmailPresents() {
		return waitUntilDisplayedElementContainsNotifyMessage(SHORT_TIME_OUT, EMAIL_DELETED);
	}

	public void createMail() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathCreateEmailButton);
		createEmailButton.click();
	}

	public void clickMoveTo() {
		moveTo.click();
	}

	public void clickSpamLink() {
		spamButton.click();
	}

	public boolean isToSpam() {
		return waitUntilDisplayedElementContainsNotifyMessage(SHORT_TIME_OUT, EMAIL_MOVED_TO_SPAM);
	}

	public void goToSpamFolder() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathSpamFolder);
		spamFolder.click();
	}

	public void goToRecycleBin() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathRecycleBinLink);
		recycleBinLink.click();
	}
	
	public void filterEmailsWithFlags() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathFilterEmailsWithFlags);
		filterEmailsWithFlags.click();
	}

	public void checkEmailsToMark() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathCheckboxes);
		for (int i = startCheckEmails; i < startCheckEmails + countEmailsToCheck; i++) {
			checkboxes.get(i).click();
		}
	}

	public void checkEmailsToUnmark() {
		waitUntilElementPresence(STANDARD_TIME_OUT, xpathCheckboxes);
		for (int i = startCheckEmails; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
	}

	public void clickButtonMoreActions() {
		dropdownMore.click();
	}

	public void markFlag() {
		flagYes.click();
	}

	public void unmarkFlag() {
		unmarkFlag.click();
	}

	public boolean isNotifyMessageUnmarkedWithFlagPresents() {
		return waitUntilDisplayedTextInElement(notifyMessage, NO_EMAILS_UNDER_THE_FILTER_CONDITION);
	}

	public boolean isNotifyMessageMarkedWithFlagPresents() {
		return waitUntilDisplayedElementContainsNotifyMessage(SHORT_TIME_OUT, EMAIL_MARKED);
	}

	public void logout() {
		logoutLink.click();
	}

	public boolean isLogoutLinkPresents() {
		return waitUntilElementIsVisibility(logoutLink);
	}
}
