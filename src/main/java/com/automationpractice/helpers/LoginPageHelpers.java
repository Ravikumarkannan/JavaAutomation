package com.automationpractice.helpers;

import org.testng.Assert;

import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.pageobjects.LoginPage;
import com.automationpractice.utilities.CommonUtilities;

public class LoginPageHelpers extends CommonUtilities {

	LoginPage login_page = new LoginPage(getDriver());
	HomePage home_page = new HomePage(getDriver());

	public void signup(String userName, String password) {
		try {
			clickOnElement(login_page.getHeaderSignup(), "Header Signup Button");
			fillTextField(login_page.getSignupUserName(), "Signup User Name", userName);
			fillTextField(login_page.getSignupPassword(), "Signup Password", password);
			clickOnElement(login_page.getButtonSignup(), "Signup Button");
			Assert.assertEquals(getAlertText(), "Sign up successful.");
			handleAlert("accept");
		} catch (Exception e) {
			publishMessageInReports_FAIL("Signin Failed " + e.getMessage());
		}
		publishMessageInReports_PASS("Signup is Successful");

	}

	public void login(String userName, String password, String welcomeText) {
		try {
			clickOnElement(login_page.getHeader_Login(), "Header Login Button");
			fillTextField(login_page.getTextBox_UserName(), "Login user name ", userName);
			fillTextField(login_page.getTextBox_Password(), "Login password ", password);
			clickOnElement(login_page.getButton_Login(), "Login Button");
			verifyElementText(home_page.getWelcomeUserText(), welcomeText);
		} catch (Exception e) {
			publishMessageInReports_FAIL("Login Failed" + e.getMessage());
		}
		publishMessageInReports_PASS("Login is Successful");
	}

	public void logout() {
		try {
			clickOnElement(home_page.getLink_logout(), "Logout Button");
			publishMessageInReports_PASS("Logout Successful");
		} catch (Exception e) {
			publishMessageInReports_FAIL("Logout Failed " + e.getMessage());
		}
	}
}
