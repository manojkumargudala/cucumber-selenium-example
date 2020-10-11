package com.storedemoqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends PageFooter {
	public HomePageObject(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@FindBy(xpath = ".//a[text()='Frames']")
	public WebElement frames;

	@FindBy(xpath = ".//a[text()='WYSIWYG Editor']")
	public WebElement WYSIWYG_Editor;

	public void verifyPageLoaded() {
		// wait.until(ExpectedConditions.visibilityOf(productCatergoy));
		wait.until(ExpectedConditions.visibilityOf(frames));
		wait.until(ExpectedConditions.visibilityOf(WYSIWYG_Editor));

	}

	public FramePageObject clickFrameAccountPage() {
		wait.until(ExpectedConditions.visibilityOf(frames));
		frames.click();
		return new FramePageObject(driver, wait);
	}
}
