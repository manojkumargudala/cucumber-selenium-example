package com.manoj.cucumber.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.manoj.cucumber.supportcode.Login;
import com.manoj.selenium.supportcode.SeleniumDriverObj;
import com.manoj.selenium.supportcode.SeleniumDriverObjImpl;
import com.storedemoqa.pageobjects.CheckOutPageObject;
import com.storedemoqa.pageobjects.HomePageObject;
import com.storedemoqa.pageobjects.PageFooter;
import com.storedemoqa.pageobjects.ProductCaterogyPageObject;

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
  ProductCaterogyPageObject productCategoryObj;
  CheckOutPageObject checkoutPage;
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
    driver = selObj.getDriver("firefox");
    wait = new WebDriverWait(driver, 10);
    initializePageObjects();

  }

  private void initializePageObjects() {
    driver.get("http://store.demoqa.com/");
    homePageObject = new HomePageObject(driver, wait);
    pageFooter = new PageFooter(driver, wait);
  }

  @When("^navigate to product Category Page$")
  public void navigate_to_product_Category_Page() throws Throwable {
    this.productCategoryObj = homePageObject.gotToProductCategory();
    productCategoryObj.verifyPageLoaded();
  }

  @When("^Add product to cart$")
  public void add_product_to_cart() throws Throwable {
    this.checkoutPage = productCategoryObj.goToCheckOutPage();

  }

  @Then("^verify \"([^\"]*)\" added to cart$")
  public void verify_added_to_cart(final String productCategory) throws Throwable {
    if (productCategory.equalsIgnoreCase("Iphone")) {
      checkoutPage.verifyIphoneAddedToCart();
    } else {
      checkoutPage.verifyMagicMouseAddedToCart();
    }
  }

  @After
  public void closeDriver() {
    driver.close();
    driver.quit();
  }
}
