package com.storedemoqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramePageObject extends PageFooter {
	public FramePageObject(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@FindBy(xpath = ".//a[text()='Nested Frames']")
	public WebElement nestedFrames;

	@FindBy(xpath = ".//a[text()='iFrame']")
	public WebElement iFrame;

	public void verifyPageLoaded() {
		// wait.until(ExpectedConditions.visibilityOf(productCatergoy));
		wait.until(ExpectedConditions.visibilityOf(nestedFrames));
		wait.until(ExpectedConditions.visibilityOf(iFrame));

	}

	public NestedFramePageObject clickNestedFrame() {
		wait.until(ExpectedConditions.visibilityOf(nestedFrames));
		nestedFrames.click();
		return new NestedFramePageObject(driver, wait);
	}
}
