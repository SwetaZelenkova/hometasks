package edu.pht.quick;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='q']")
	private WebElement searchField;
	
	@FindBy(xpath = "//*[@id='search:submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//*[@id='js-result_1']/h3/a")
	private WebElement resultLink;

	public SearchPage(WebDriver webdriver)
    {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
    }
	
	public void enterQueryInSearchField(String query)
    {
		searchField.clear();
		searchField.sendKeys(query);
    }
	
	public void clickSearchButton()
    {
		searchButton.click();
    }
	
	public boolean resultLinkPresents()
    {
        return elementIsDisplayed(resultLink);
    }
    
    private boolean elementIsDisplayed(WebElement webElement) {
		return (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    	
    }
}
