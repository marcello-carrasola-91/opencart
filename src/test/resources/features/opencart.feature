@opencart
Feature: Open website and search an iPhone.


  Scenario: Go opencart, search an iPhone, add it to the cart and remove it from there
    Given I Go To opencart Page
    Then I search by "iPhone"
    And I click on element "1"
    Then I click on Add to Cart
    And I click on Shopping Cart
    And I click on View Cart
    Then I Validate "iPhone" is in the cart
    Then Remove element from chart
    And I click on Shopping Cart
    Then Validate chart is empty