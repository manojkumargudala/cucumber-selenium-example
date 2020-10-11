Feature: Automation BDD driver framework with selenium
  This feature will bind the selenium automation with the BBD framework

  Background: 
    Given navigate to base URL

  Scenario: TestCase#1 Login into site
    Given the below are the user credentials login
      | userId | pasword |
      | true   | true    |
    When navigate to Frame object Page
    And click on nested frame link
    Then verify "BOTTOM" frame is displayed
