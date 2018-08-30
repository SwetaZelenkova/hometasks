package edu.pht.bddgherkincucumber.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.pht.bddgherkincucumber.utils.Const;

public class EmailPage extends AbstractPage {
	
	//private final String xpathCheckbox = "(//div[@class='b-checkbox__box'])[3]";
	private final String xpathCheckbox = "//*[@id='b-letters']/div[1]/div[2]/div/div[2]/div[1]/div/a/div[1]/div/div[1]";
	private final String xpathRecycleBinLink = "//*[@id='b-nav_folders']/div/div[5]/a";
	private final String xpathButtonCreateMail = "(//a[@title='Написать письмо (N)'])[1]";
	private final String xpathSpamFolder = "//*[@id='b-nav_folders']/div/div[4]/a";
	//private final String xpathSpamFolder = "//div[@data-id='950']/a";
	private final String xpathCheckboxes = "//div[@class='b-checkbox__box']";
	private final int countEmailsToCheck = 3;
	private final int startCheckEmails = 2;
	
	@FindBy(xpath = xpathRecycleBinLink)
	private WebElement recycleBinLink;

	@FindBy(xpath = xpathCheckbox)
	private WebElement checkbox;

	@FindBy(xpath = "//*[@id='b-toolbar__right']/div[2]/div/div[2]/div[2]/div/div[1]")
	private WebElement deleteButton;

	@FindBy(xpath = "//*[@id='Notify']/div[1]/div/span")
	private WebElement notifyMessage;

	@FindBy(xpath = "//*[@id='PH_logoutLink']")
	private WebElement logoutLink;
	
	@FindBy(xpath = xpathButtonCreateMail)
	private WebElement buttonCreateMail;

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
	
	public EmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void moveToRecycleBin() {
		waitUntilElementPresence(WAIT, xpathRecycleBinLink);
		recycleBinLink.click();
	}
	
	public void checkMail() {
		waitUntilElementPresence(WAIT, xpathCheckbox);
		checkbox.click();
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

	public boolean isNotifyDeleteMailPresents() {
		return waitUntilDisplayedElementContainsNotifyMessage(SHORT_WAIT, Const.EMAIL_DELETED);
	}
	
	public void logout() {
		logoutLink.click();
	}
	
	public boolean isLogoutLinkPresents() {
        return (new WebDriverWait(driver, SHORT_WAIT)).until(ExpectedConditions.visibilityOf(logoutLink)).isDisplayed();
    }
	
	public void createMail() {
		waitUntilElementPresence(WAIT, xpathButtonCreateMail);
		buttonCreateMail.click();
	}
	
	/*public void checkMailToSpam() {
		waitUntilElementPresence(WAIT, xpathCheckbox);
		checkbox.click();
	}*/

	public void clickMoveTo() {
		moveTo.click();
	}
	
	public void clickSpamLink() {
		spamButton.click();
	}

	public boolean isToSpam() {
		return waitUntilDisplayedElementContainsNotifyMessage(SHORT_WAIT, Const.EMAIL_MOVED_TO_SPAM);
	}
	
	public void goSpamFolder() {
		waitUntilElementPresence(WAIT, xpathSpamFolder);
		spamFolder.click();
	}
	
	public void checkEmailsToMark() {
		waitUntilElementPresence(WAIT, xpathCheckboxes);
		for (int i = startCheckEmails; i < startCheckEmails + countEmailsToCheck; i++) {
			checkboxes.get(i).click();
		}
	}
	
	public void clickButtonMoreActions() {
		dropdownMore.click();
	}
	
	public void markFlag() {
		flagYes.click();
	}
	
	public boolean isNotifyMessageMarkedWithFlagPresents() {
		return waitUntilDisplayedElementContainsNotifyMessage(SHORT_WAIT, Const.EMAIL_MARKED);
	}
}
