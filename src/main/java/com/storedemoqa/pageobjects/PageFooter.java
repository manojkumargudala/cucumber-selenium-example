package com.storedemoqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFooter extends PageHeader {
	public PageFooter(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@FindBy(xpath = ".//a[text()='Elemental Selenium']")
	WebElement elementSelenium;

	public void clickSpHomeLink() {
		wait.until(ExpectedConditions.visibilityOf(elementSelenium));
		elementSelenium.click();
	}
}
