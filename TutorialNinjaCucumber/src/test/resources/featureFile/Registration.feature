Feature: Login TutorialsNinja application
  To verify user registration functionality with valid credentials

  @ValidRegistration
  Scenario: Register with valid credentials
    Given the user is on the Home page
    And the user clicks on My Account link and then clicks on Registration link
    When the user enters registration details
      | myl       | G        | mailu@gmail.com | 1472583690 | password | password        |
    And the user agrees to the privacy policy
    And the user clicks on Continue button
    Then the user should see a successful registration message
