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
import cucumber.api.PendingException;
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

  @Before
  public void initiateDriverObject() {
    System.out.println("intialize we driver object");
    SeleniumDriverObj selObj = new SeleniumDriverObjImpl();
    driver = selObj.getDriver("firefox");
    wait = new WebDriverWait(driver, 10);
  }

  @Given("^the below are the user credentials login$")
  public void the_below_are_the_user_credentials_login(final DataTable loginDetialsDataTable) {
    List<Login> loginList = loginDetialsDataTable.asList(Login.class);
    System.out.println("login user id " + loginList.get(0).getUserId());
  }

  @Given("^navigate to base URL$")
  public void navigate_to_base_URL() throws Throwable {
    driver.get("http://store.demoqa.com/");
    homePageObject = new HomePageObject(driver, wait);
    pageFooter = new PageFooter(driver, wait);

  }

  @When("^Google searches for \"([^\"]*)\"$")
  public void google_searches_for(final String searchString) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^there should be results count is (\\d+)$")
  public void there_should_be_results_count_is(final int resultCount) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^verify first site in the results is \"([^\"]*)\"$")
  public void verify_first_site_in_the_results_is(final String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
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
