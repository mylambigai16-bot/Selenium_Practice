package com.actions;

import org.openqa.selenium.support.PageFactory;

import com.pages.DashboardPage;
import com.utilities.HelperClass;

public class DashboardAction {
	
	DashboardPage dashboardPage=null;
	public DashboardAction() {
		this.dashboardPage = new DashboardPage();
		PageFactory.initElements(HelperClass.getDriver(), dashboardPage );
	}
	
	public String getDashboardPageTest() {
		return dashboardPage.dashboard.getText();
	}

}
