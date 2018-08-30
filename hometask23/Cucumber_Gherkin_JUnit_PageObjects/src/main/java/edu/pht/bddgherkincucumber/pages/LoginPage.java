package edu.pht.bddgherkincucumber.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends AbstractPage {
	
	private final int countIcons = 7;
	public static final String INVALID_USERNAME_OR_PASSWORD = "Неверное имя или пароль";
	
	private final String xpathIcons = 
			"//img[@class='o-media__img projects-item__icon']";

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:domain")
	private WebElement domainDropdown;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id='mailbox:submit']/input")
	private WebElement buttonEnter;

	@FindBy(xpath = "//*[@id='mailbox:error']")
	public WebElement messageError;
	
	@FindBy(xpath = xpathIcons)
	private List<WebElement> icons;

	public LoginPage(WebDriver driver) {
		super(driver);
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

	public boolean isMessageErrorPresents() {
		return isDisplayedTextInElement(messageError, INVALID_USERNAME_OR_PASSWORD);
	}
	
	public boolean countAllIcons() {
		if (isIconsListNotEmpty()) {
			if (icons.size() == countIcons) {
				return true;
			}
		}
		return false;
	}
	
	public boolean arePresentAndDisplayedAllIcons() {
		boolean exist = true;
		try {
			if (isIconsListNotEmpty()) {
				for (int i = 0; i < icons.size(); i++) {
					if (icons.get(i).isDisplayed()) {
						exist &= true;
					} else {
						exist &= false;
					}
				}
				if (exist)
					return true;
			}

		} catch (NoSuchElementException e) {
			return false;
		}

		return false;
	}
	
	public boolean isIconsListNotEmpty() {
		return waitUntilElementPresence(WAIT, xpathIcons) != null;
	}
}
