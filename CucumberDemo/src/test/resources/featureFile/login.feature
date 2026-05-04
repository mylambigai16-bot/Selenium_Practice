Feature: Login to DemoBlaze application

  Background:
    Given User is on Home page
    And Click on login

# 1. valid login
  @ValidCredentials @smoke @myl
  Scenario: Login with valid credential
    When User enters valid username as "admin" and password as "admin"
    Then User should be able to login successfully
    
# 2. Invalid Login
  @InvalidCredential @smoke @myl
  Scenario: Login with invalid credential
    When the User enters username as "Admin" and invalid password as "Admin"
    Then the User should get the error message

