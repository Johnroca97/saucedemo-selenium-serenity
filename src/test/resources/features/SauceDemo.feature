@SauceDemo
Feature: Complete Shopping Flow in SauceDemo
  As a customer
  I want to complete a full shopping experience
  So that I can purchase products successfully

  Background:
    Given I am on the SauceDemo login page

  @smoke @login
  Scenario: Successful login with valid credentials
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the products page

  @complete-flow
  Scenario: Complete shopping flow - Add products and checkout
    When I login with username "standard_user" and password "secret_sauce"
    And I should see the products page
    When I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bike Light" to the cart
    Then I should see 2 items in the cart
    When I go to the cart
    Then I should see "Sauce Labs Backpack" in the cart
    And I should see "Sauce Labs Bike Light" in the cart
    When I proceed to checkout
    And I fill the checkout information with:
      | firstName  | John  |
      | lastName   | Doe   |
      | postalCode | 12345 |
    And I continue to checkout overview
    Then I should see the order summary
    When I finish the order
    Then I should see the order confirmation
    And I should see "Thank you for your order!" message

  @negative @login
  Scenario: Login with invalid credentials
    When I login with username "invalid_user" and password "wrong_password"
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  @cart-management
  Scenario: Add and remove products from cart
    When I login with username "standard_user" and password "secret_sauce"
    And I should see the products page
    When I add "Sauce Labs Backpack" to the cart
    Then I should see 1 items in the cart
    When I remove "Sauce Labs Backpack" from the cart
    Then I should see 0 items in the cart
