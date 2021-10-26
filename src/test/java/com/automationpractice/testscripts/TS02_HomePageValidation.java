package com.automationpractice.testscripts;

import org.testng.annotations.Test;

import com.automationpractice.helpers.HomePageHelpers;
import com.automationpractice.testbase.TestBase;

public class TS02_HomePageValidation extends TestBase {

	@Test
	public void tc03_validate_Header_Links() {
		HomePageHelpers helper_Home_page = new HomePageHelpers();
		helper_Home_page.validate_header_links();
	}

	@Test
	public void tc04_validate_homepage_products() {
		HomePageHelpers helper_Home_page = new HomePageHelpers();
		helper_Home_page.validate_homepage_prodcuct_titles();
		helper_Home_page.validate_homepage_product_images();
	}

	public void tc03_validate_homepage_footer() {

	}

}
