package edu.pht.pageclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Driver {
	
	private WebDriver driver;
	private WebDriverWait wait;

	protected WebDriver getDriver() {
		if (driver == null) {
			String exePath = "D:\\SeleniumDriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
		return driver;
	}

	protected WebDriverWait getWait(long timeInSeconds) {
		if (driver == null) {
			wait = (new WebDriverWait(getDriver(), timeInSeconds));
		} else {
			wait = (new WebDriverWait(driver, timeInSeconds));
		}
		return wait;
	}

	protected void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
