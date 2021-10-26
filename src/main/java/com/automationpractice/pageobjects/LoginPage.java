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
	private WebElement headerLogin;

	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement loginUserName;

	@FindBy(xpath = "//input[@id='loginpassword']")
	private WebElement loginPassword;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement buttonLogin;

	@FindBy(xpath = "//a[@id='signin2']")
	private WebElement headerSignup;

	@FindBy(xpath = "//input[@id='sign-username']")
	private WebElement signupUserName;

	@FindBy(xpath = "//input[@id='sign-password']")
	private WebElement signupPassword;

	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement buttonSignup;
	
	public WebElement getButtonClose() {
		return buttonClose;
	}

	@FindBy(xpath = "(//button[text()='Close'])[2]")
	private WebElement buttonClose;

	public WebElement getHeader_Login() {
		return headerLogin;
	}

	public WebElement getHeaderSignup() {
		return headerSignup;
	}

	public WebElement getSignupUserName() {
		return signupUserName;
	}

	public WebElement getSignupPassword() {
		return signupPassword;
	}

	public WebElement getButtonSignup() {
		return buttonSignup;
	}

	public WebElement getTextBox_UserName() {
		return loginUserName;
	}

	public WebElement getTextBox_Password() {
		return loginPassword;
	}

	public WebElement getButton_Login() {
		return buttonLogin;
	}

}
