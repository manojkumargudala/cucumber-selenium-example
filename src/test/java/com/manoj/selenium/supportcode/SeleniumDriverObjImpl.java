package com.manoj.selenium.supportcode;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SeleniumDriverObjImpl implements SeleniumDriverObj {
	WebDriver driver;
	EventFiringWebDriver eventFiringWebDriver;

	@Override
	public WebDriver getDriver(final String browserName) {
		getBrowerSpecificDriver(browserName);
		driver.manage().window().maximize();
		return driver;
	}

	private void getBrowerSpecificDriver(final String browserName) {
		if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if (browserName.equalsIgnoreCase("Chrome")) {
			File f = new File("chromdriver.exe");
			if (f.exists()) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", "chromedriver");
			}
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("Headless")) {
			File f = new File("chromdriver.exe");
			if (f.exists()) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", "chromedriver");
			}
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors");
			driver = new ChromeDriver(options);

		}
	}
}
