Feature: Login OrangeHRM application

@ValidCretential
Scenario: Login with valid credential
Given the User on the page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When the User enters valid username and password and click on login button
Then the User should able to login successfully and should see dashboard page