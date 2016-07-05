package com.storedemoqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {
  @FindBy(xpath = ".//a[text()='My Account']")
  public WebElement myAccount;
  WebDriver driver;
  WebDriverWait wait;
  @FindBy(xpath = ".//a[text()='Product Category']")
  WebElement productCatergoy;
  @FindBy(xpath = ".//a[text()='All Product']")
  WebElement allProductsPage;
  @FindBy(xpath = ".//ul[@id='slide_menu']")
  WebElement slideMenu;
  @FindBy(xpath = ".//a[text()='iMacs']")
  WebElement imacsCategory;
  @FindBy(xpath = ".//a[text()='iPads']")
  WebElement iPadsCategory;
  @FindBy(xpath = ".//a[text()='iPhones']")
  WebElement iPhonesCategory;
  @FindBy(xpath = ".//a[text()='iPods']")
  WebElement iPodsCategory;
  @FindBy(xpath = ".//a[text()='Checkout']")
  WebElement checkoutFromHome;
  PageFooter pageFooter;

  public HomePageObject(final WebDriver driver, final WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    PageFactory.initElements(driver, this);
    this.pageFooter = new PageFooter(driver, wait);
  }

  public ProductCaterogyPageObject gotToProductCategory() {
    ProductCaterogyPageObject productCaterogyPageObject =
        new ProductCaterogyPageObject(driver, wait, pageFooter);
    wait.until(ExpectedConditions.visibilityOf(productCatergoy));
    productCatergoy.click();
    return productCaterogyPageObject;
  }

  public CheckOutPageObject goToCheckOutPage() {
    CheckOutPageObject checkOutPageObject = new CheckOutPageObject(driver, wait);
    wait.until(ExpectedConditions.visibilityOf(checkoutFromHome));
    checkoutFromHome.click();
    return checkOutPageObject;
  }

  public void verifyPageLoaded() {
    wait.until(ExpectedConditions.visibilityOf(productCatergoy));
    wait.until(ExpectedConditions.visibilityOf(allProductsPage));
    wait.until(ExpectedConditions.visibilityOf(slideMenu));

  }
}
