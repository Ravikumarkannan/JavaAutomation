package com.automationpractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nameofuser']")
	private WebElement welcomeUserText;

	@FindBy(xpath = "//a[contains(text(), 'Phones')]")
	private WebElement catetory_Phones;

	@FindBy(xpath = "//a[contains(text(), 'Laptops')]")
	private WebElement catetory_Laptops;

	@FindBy(xpath = "//a[contains(text(), 'Monitors')]")
	private WebElement catetory_Monitors;

	@FindBy(xpath = "//a[@id='logout2']")
	private WebElement link_logout;

	@FindBy(xpath = "//div[@id='navbarExample']/ul/child::li")
	private List<WebElement> header_Links;
	
	@FindBy(xpath = "//div[@id='footc']/following-sibling::footer")
	private WebElement copyright_footer;

	public WebElement getCopyright_footer() {
		return copyright_footer;
	}

	public List<WebElement> getHome_product_images() {
		return home_product_images;
	}

	public List<WebElement> getHome_product_titles() {
		return home_product_titles;
	}

	@FindBy(xpath = "//div[@id='tbodyid']/div/div/a/img")
	private List<WebElement> home_product_images;

	@FindBy(xpath = "//div[@id='tbodyid']/div/div/div/h4[@class='card-title']/a")
	private List<WebElement> home_product_titles;

	public WebElement getWelcomeUserText() {
		return welcomeUserText;
	}

	public WebElement getCatetory_Phones() {
		return catetory_Phones;
	}

	public WebElement getCatetory_Laptops() {
		return catetory_Laptops;
	}

	public WebElement getCatetory_Monitors() {
		return catetory_Monitors;
	}

	public WebElement getLink_logout() {
		return link_logout;
	}

	public List<WebElement> getHeader_Links() {
		return header_Links;
	}

}
