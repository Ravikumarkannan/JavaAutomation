package com.automationpractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* Page Factory will initialize every WebElement variable with a reference 
 * to a corresponding element on the actual web page based on “locators” defined*/

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	private WebElement header_Login;

	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement textBox_UserName;

	@FindBy(xpath = "//input[@id='loginpassword']")
	private WebElement textBox_Password;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement button_Login;

	public WebElement getHeader_Login() {
		return header_Login;
	}

	public WebElement getTextBox_UserName() {
		return textBox_UserName;
	}

	public WebElement getTextBox_Password() {
		return textBox_Password;
	}

	public WebElement getButton_Login() {
		return button_Login;
	}

}
