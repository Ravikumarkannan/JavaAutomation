package com.automationpractice.helpers;

import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.pageobjects.LoginPage;
import com.automationpractice.utilities.CommonUtilities;

public class LoginPageHelpers extends CommonUtilities {

	LoginPage login_page = new LoginPage(getDriver());
	HomePage home_page = new HomePage(getDriver());

	public void login() {
		try {
			clickOnElement(login_page.getHeader_Login(), "Header Login Button");
			fillTextField(login_page.getTextBox_UserName(), "Login user name", "testnew1");
			fillTextField(login_page.getTextBox_Password(), "Login password", "test@123");
			clickOnElement(login_page.getButton_Login(), "Login Button");
			verifyElementText(home_page.getWelcomeUserText(), "Welcome testnew1");
			publishMessageInReports_PASS("Login Successful");
		} catch (Exception e) {
			publishMessageInReports_FAIL("Login Failed"  + e.getStackTrace());
		}
	}
	
	public void logout() {
		try {
			clickOnElement(home_page.getLink_logout(), "Logout Button");
			publishMessageInReports_PASS("Logout Successful");
		} catch (Exception e) {
			publishMessageInReports_FAIL("Logout Failed " + e.getStackTrace());
		}
	}
}
