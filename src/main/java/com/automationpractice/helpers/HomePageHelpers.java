package com.automationpractice.helpers;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.testbase.TestBase;
import com.automationpractice.utilities.CommonUtilities;

public class HomePageHelpers extends CommonUtilities {

	HomePage home_Page = new HomePage(getDriver());

	Properties properties = TestBase.properties;

	public void validate_header_links() {

		List<WebElement> headerElements = home_Page.getHeader_Links();
		List<String> header_texts = new ArrayList<String>();

		for (int element = 0; element < headerElements.size(); element++) {
			String headerText = getElementText(headerElements.get(element));
			header_texts.add(headerText);
		}
		System.out.println("header links: " + header_texts);
	}

	public void validate_homepage_prodcuct_titles() {
		List<WebElement> headerProductTitles = home_Page.getHome_product_titles();

		for (int count = 0; count < headerProductTitles.size(); count++) {
			String actual_product_title = getElementText(headerProductTitles.get(count));
			String expected_product_title = properties
					.getProperty("title_homepage_product" + String.valueOf(count + 1));
			assertEquals(actual_product_title, expected_product_title);
		}

	}
	
	public void validate_homepage_product_images() {
		List<WebElement> headerProductImages = home_Page.getHome_product_images();
		
		for (int count = 0; count < headerProductImages.size(); count++) {
			isElementPresent(headerProductImages.get(count));
		}
	}

}
