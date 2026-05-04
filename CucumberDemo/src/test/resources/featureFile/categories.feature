Feature: Checking the categories functionality

  Background:
    Given User on the Home Page
# Phone category should display

  @Phone_category
  Scenario: Fileterd phone category should display
    When User click on the phone category
    Then USer can see the filtered phone category
# Laptop category should display

  @Laptop_category
  Scenario: Fileterd laptop category should displa
    When User click on the laptop category
    Then USer can see the filtered laptop category
# User can navigate to prevoius or next

  @Navigategation
  Scenario: Navigate to prevoius or next page
    Then the user can click and navigate to prevoius or next page
