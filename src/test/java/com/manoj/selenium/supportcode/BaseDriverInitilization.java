package com.manoj.selenium.supportcode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public abstract class BaseDriverInitilization {
  protected WebDriver driver;
  protected Wait<WebDriver> wait;

  @Before("@InitializeWebDriver")
  public void initiateDriverObject() {
    SeleniumDriverObj selObj = new SeleniumDriverObjImpl();
    driver = selObj.getDriver("firefox");
    wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
        .pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class);
  }


  @After("@InitializeWebDriver")
  public void closeDriver() {
    driver.close();
    driver.quit();
  }
}
