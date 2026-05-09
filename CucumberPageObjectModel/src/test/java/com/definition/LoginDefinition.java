package com.definition;

import org.testng.Assert;

import com.actions.DashboardAction;
import com.actions.LoginAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;

public class LoginDefinition {
	
	LoginAction loginAction=new LoginAction();
	DashboardAction dashboardAction=new DashboardAction();

	@Given("the User on the page {string}")
	public void the_user_on_the_page(String url) {
		HelperClass.openPage(url);
	}
	@When("the User enters valid username and password and click on login button")
	public void the_user_enters_valid_username_and_password_and_click_on_login_button() {
		loginAction.login();
	}
	@Then("the User should able to login successfully and should see dashboard page")
	public void the_user_should_able_to_login_successfully_and_should_see_dashboard_page() {
		Assert.assertEquals(dashboardAction.getDashboardPageTest(),"Dashboard");
	}

}
