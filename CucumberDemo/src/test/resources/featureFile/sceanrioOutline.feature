Feature: Example of Scenario outline

  @InvalidCredentails
  Scenario Outline: Given User on the Login page
    And User click on the Login link
    When the User enters username as "<username>" and the password as "<password>"
    And Click on the login button
    Then User get the message like "<errorMessage>"

     Examples:
      | username | password | errorMessage                         |
      | 123      | 1234     | Wrong password.                      |
      | 123      |          | Please fill out Username and Password. |
      | myl@     | 123      | User does not exist.                 |
 