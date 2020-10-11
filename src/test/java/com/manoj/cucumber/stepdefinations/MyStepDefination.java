package com.manoj.cucumber.stepdefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.manoj.cucumber.supportcode.Login;
import com.manoj.selenium.supportcode.SeleniumDriverObj;
import com.manoj.selenium.supportcode.SeleniumDriverObjImpl;
import com.storedemoqa.pageobjects.FramePageObject;
import com.storedemoqa.pageobjects.HomePageObject;
import com.storedemoqa.pageobjects.NestedFramePageObject;
import com.storedemoqa.pageobjects.PageFooter;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepDefination {
	protected WebDriver driver;
	protected WebDriverWait wait;
	HomePageObject homePageObject;
	PageFooter pageFooter;
	FramePageObject framePageObject;
	NestedFramePageObject nestedFramePageObject;
	SeleniumDriverObj selObj;

	@Before
	public void initiateDriverObject() {
		System.out.println("intialize we driver object");
		selObj = new SeleniumDriverObjImpl();

	}

	@Given("^navigate to base URL in headless browser$")
	public void navigate_to_base_URL_in_headless_browser() throws Throwable {
		driver = selObj.getDriver("Headless");
		wait = new WebDriverWait(driver, 30);
		initializePageObjects();
	}

	@Given("^the below are the user credentials login$")
	public void the_below_are_the_user_credentials_login(final DataTable loginDetialsDataTable) {
		List<Login> loginList = loginDetialsDataTable.asList(Login.class);
		System.out.println("login user id " + loginList.get(0).getUserId());
	}

	@Given("^navigate to base URL$")
	public void navigate_to_base_URL() {
		driver = selObj.getDriver("chrome");
		wait = new WebDriverWait(driver, 10);
		initializePageObjects();

	}

	private void initializePageObjects() {
		driver.get("http://the-internet.herokuapp.com");
		homePageObject = new HomePageObject(driver, wait);
		pageFooter = new PageFooter(driver, wait);
	}

	@When("^navigate to Frame object Page$")
	public void navigate_to_product_Category_Page() throws Throwable {
		this.framePageObject = homePageObject.clickFrameAccountPage();
		framePageObject.verifyPageLoaded();
	}

	@When("^click on nested frame link$")
	public void add_product_to_cart() throws Throwable {
		this.nestedFramePageObject = framePageObject.clickNestedFrame();

	}

	@Then("^verify \"([^\"]*)\" frame is displayed$")
	public void verify_added_to_cart(final String productCategory) throws Throwable {
		String bottonFrameContent = nestedFramePageObject.getBottomFrameContent();
		System.out.println(bottonFrameContent);
		Assert.assertEquals(productCategory, bottonFrameContent);
	}

	@After
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
