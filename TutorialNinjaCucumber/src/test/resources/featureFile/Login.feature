Feature: Login the tutorailsNinja application
User login with valid and invalid credential

  Background:
    Given the user is on the Home page
    And the user clicks on My Account link and then clicks on Login link

  @ValidLogin
  Scenario Outline: Login with valid Credential
    When the user enter valid email address as "<emailAddress>"  and password as "<password>"
    And click on Login button
    Then the user should able to login successfully

  Example:
      | mailu@gmail.com | password |

  @InvlidLogin
  Scenario Outline:
    When the user enters Invalid email addres as "<emailAddress>" and password as "<password>"
    And the user clicks on login button
    Then the user should get the error message

  Example:
      |   |    |
