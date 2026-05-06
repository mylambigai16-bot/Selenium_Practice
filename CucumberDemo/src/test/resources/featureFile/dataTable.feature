Feature: Example of Scenario outline

  @InvalidCredentails
  Scenario: Given User on the Login page
    And User click on the Login link
    When the User enters username as and the password as
      | 123 | 1234 |
    And Click on the login button
    Then User get the message like "Wrong password."
     
