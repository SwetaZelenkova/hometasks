package edu.pht.cucumberjunit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private static final Logger logger = Logger.getLogger(Driver.class);
	private static final String FILE_WITH_DRIVER_PARAMS = "configs/Configuration.properties";
	private static WebDriver instance = null;

	private Driver() {
	}

	public static WebDriver getInstance() {
		if (instance == null) {
			logger.info("init instace..........");
			Properties props = new Properties();
			try {
				props.load(new FileInputStream(FILE_WITH_DRIVER_PARAMS));
			} catch (FileNotFoundException e) {
				logger.info("file..with..path.." + FILE_WITH_DRIVER_PARAMS + "..not..found.." + e.getMessage());
			} catch (IOException e) {
				logger.info("i/o..exc.." + e.getMessage());
			}
			String exePath = props.getProperty("PATH_TO_DRIVER");
			System.setProperty(props.getProperty("NAME_OF_DRIVER"), exePath);
			instance = new ChromeDriver();
			instance.manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty("IMPLICITLY_WAIT")),
					TimeUnit.SECONDS);
		}
		return instance;
	}

	public static void killInstance() {
		logger.info("kill instance..........");
		if (instance != null) {
			instance.quit();
			instance = null;
		}
	}
}
