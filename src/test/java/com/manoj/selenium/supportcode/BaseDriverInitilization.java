package com.manoj.selenium.supportcode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public abstract class BaseDriverInitilization {
  protected WebDriver driver;
  protected WebDriverWait wait;

  @Before("@InitializeWebDriver")
  public void initiateDriverObject() {
    // readProp = new ReadPropertyDataImpl("demoqaprops.properties");
    SeleniumDriverObj selObj = new SeleniumDriverObjImpl();
    driver = selObj.getDriver("firefox");
    // driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 10);
  }


  @After("@DestoryWebDriver")
  public void closeDriver() {
    driver.close();
    driver.quit();
  }
}
