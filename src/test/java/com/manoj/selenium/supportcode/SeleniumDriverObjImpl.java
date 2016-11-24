package com.manoj.selenium.supportcode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.storedemoqa.selenium.ScreenCaptureHtmlUnitDriver;


public class SeleniumDriverObjImpl implements SeleniumDriverObj {
  WebDriver driver;
  ScreenCaptureHtmlUnitDriver mydriver;
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
      System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
      driver = new ChromeDriver();
    }
    if (browserName.equalsIgnoreCase("Headless")) {
      mydriver = new ScreenCaptureHtmlUnitDriver();
      mydriver.setJavascriptEnabled(true);
      driver = mydriver;
    }
  }
}
