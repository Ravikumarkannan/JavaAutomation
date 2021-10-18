package com.automationpractice.helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.automationpractice.pages.HomePage;
import com.automationpractice.utilities.CommonUtilities;

public class HomePageHelpers extends CommonUtilities{
	
	HomePage home_Page = new HomePage(getDriver());
	
	public void validate_header_links() {
		
		List<WebElement> elements = home_Page.getHeader_Links();
		List<String> header_texts = new ArrayList<String>();
		
		for(int element=0; element<elements.size(); element++) {
			String headerText = getElementText(elements.get(element));
			header_texts.add(headerText);
		}
		System.out.println("header links: "+header_texts);
	}
	
}
