package com.automationpractice.testscripts;

import org.testng.annotations.Test;

import com.automationpractice.helpers.LoginPageHelpers;
import com.automationpractice.testbase.TestBase;

public class TS01_LoginValidation extends TestBase {

	@Test(enabled = false)
	public void tc01_signup_validation() {
		LoginPageHelpers helper_Login_page = new LoginPageHelpers();
		helper_Login_page.signup("userfortest987", "oookjjuahs344");
	}

	@Test(dataProvider = "loginTestData")
	public void tc02_login_Logout_Validation(String userName, String password, String welcomeText) {
		LoginPageHelpers helper_Login_page = new LoginPageHelpers();
		helper_Login_page.login(userName, password, welcomeText);
		helper_Login_page.logout();
	}

}