Feature: Cart Functionality

  Background:
    Given the user is on the cart page
    And the user has added  product to the cart

#Check wether the added product added in the cart
Scenario: Check the added product dispalyed in the cart
Then User can see the added product in tha cart page

# Remove product from cart
  @Remove_Product
  Scenario: Remove a product from the cart
    When the user removes the product from the cart
    Then the product should be removed successfully

# Place an order of the in the cart
  @Place_Order
  Scenario: Place an order from the cart
    When the user proceeds to checkout
    And places the order
    Then the order should be placed successfully

# User can see the total amount of the item added in the cart
  @Total_amount
  Scenario:
    Then the user ca see the total amount of the product added in the cart
    
