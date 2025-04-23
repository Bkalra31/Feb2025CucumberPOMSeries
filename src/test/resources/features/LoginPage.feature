Feature: Login Page Feature

  Scenario: Check login page title
    Given the user is on the login page
    When the user checks the page title
    Then the page title should be "Account Login"

  Scenario: Check login page URL
    Given the user is on the login page
    When the user checks the page URL
    Then the URL should contain "account/login"

  Scenario: Check forgot password link existence
    Given the user is on the login page
    When the user checks the forgot password link
    Then the forgot password link should be displayed


  Scenario: Login to application
    Given the user is on the login page
    When the user logs in with username "feb2024@gmail.com" and password "Selenium@12345"
    Then the user should be redirected to the accounts page with title "My Account"

  Scenario: add to cart
    Given the user is on the login page
    When the user logs in with username "feb2024@gmail.com" and password "Selenium@12345"
    Then the user should be redirected to the accounts page with title "My Account"
    And user searches for "macbook"
    Then product info is displayed
    And user adds the product into cart
    Then check cart is updated with the product "macbook"
