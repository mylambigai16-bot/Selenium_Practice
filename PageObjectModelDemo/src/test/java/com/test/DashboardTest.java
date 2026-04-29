package com.test;

import com.pages.DashboardPage;

import com.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

	@Test
	public void dashboardTest() {
		loginObj = new LoginPage(driver);

		loginObj.login("Admin", "admin123");

		dashboardObj = new DashboardPage(driver);
		Assert.assertTrue(dashboardObj.getHomePageText().contains("Dashboard"));

	}
}
