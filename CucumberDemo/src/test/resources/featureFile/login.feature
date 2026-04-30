Feature: Login to HRM application

@ValidCredentials
Scenario: Login with valid credential

Given User is on Home page
When User enters userName as "Admin"
And User enters password as "Admin123"
Then User should be able to login successfully