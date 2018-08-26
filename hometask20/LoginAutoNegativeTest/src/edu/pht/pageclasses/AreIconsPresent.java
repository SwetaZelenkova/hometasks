package edu.pht.pageclasses;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AreIconsPresent extends Driver {

	private final String xpathIcons = 
			"//img[@class='o-media__img projects-item__icon']";

	@FindBy(xpath = xpathIcons)
	private List<WebElement> icons;

	public AreIconsPresent() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean checkIcons() {
		boolean exist = true;
		try {
			if (getWait(100).until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath(xpathIcons))) != null) {

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

}
