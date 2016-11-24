Feature: Automation BDD driver framework with selenium
  This feature will bind the selenium automation with the BBD framework

  Background: 
    Given navigate to base URL in headless browser

  @InitializeWebDriver
  Scenario: TestCase#1 Login into site
    Given the below are the user credentials login
      | userId | pasword |
      | true   | true    |
    When navigate to product Category Page
    And Add product to cart
    Then verify "Iphone" added to cart
