package com.automationpractice.testscripts;

import org.testng.annotations.Test;

import com.automationpractice.helpers.HomePageHelpers;
import com.automationpractice.helpers.LoginPageHelpers;
import com.automationpractice.testbase.TestBase;

public class TC01_Login_Logout extends TestBase {

	
	@Test
	public void login_Logout_Validation() {
		LoginPageHelpers helper_Login_page = new LoginPageHelpers();
		
		helper_Login_page.login();
		helper_Login_page.logout();
	}
	
	@Test
	public void validate_Header_Links() {
		HomePageHelpers helper_Home_page = new HomePageHelpers();
		helper_Home_page.validate_header_links(); 
	}
}