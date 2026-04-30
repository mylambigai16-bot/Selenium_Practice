package com.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition {
	@Given("User is on Home page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	    System.out.println("Step 1");
	}

	@When("User enters userName as {string}")
	public void user_enters_user_name_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Step 2");
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Step 3");
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Step 4");
	}


}
