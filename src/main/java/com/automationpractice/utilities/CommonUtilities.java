package com.automationpractice.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.automationpractice.constants.Constants;
import com.automationpractice.listeners.TestListener;
import com.automationpractice.testbase.TestBase;
import com.aventstack.extentreports.Status;

public class CommonUtilities extends TestBase {

	WebDriverWait wait = new WebDriverWait(getDriver(), 20);

	public void fillTextField(WebElement element, String textBoxName, String valueToBeFilled) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(valueToBeFilled);
			publishMessageInReports("Field " + textBoxName + " is filled with " + valueToBeFilled);
		} catch (Exception e) {
			publishMessageInReports_FAIL("Value enter in field" + textBoxName + "is failed due to" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickOnElement(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			publishMessageInReports("Clicked on " + elementName);
		} catch (Exception e) {
			publishMessageInReports_FAIL("Unable to click " + elementName + e.getMessage());
			e.printStackTrace();
		}
	}

	public Boolean isElementPresent(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();

	}

	public String getElementText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public void verifyElementText(WebElement element, String textExpected) {
		String elementText = getElementText(element);
		Assert.assertEquals(elementText, textExpected);
	}

	public void publishMessageInReports(String message) {
		log.info(message);
		TestListener.extentTest.get().log(Status.INFO, message);
		Reporter.log(message);

	}

	protected void publishMessageInReports_PASS(String message) {
		log.info(message);
		TestListener.extentTest.get().log(Status.PASS, message);
		Reporter.log(message);
	}

	protected void publishMessageInReports_FAIL(String message) {
		log.info(message);
		TestListener.extentTest.get().log(Status.FAIL, message);
		Reporter.log(message);
	}

	public void captureScreenShot(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		publishMessageInReports("Capturing screenshot: " + screenshotName);
		
		try {
			FileUtils.copyFile(srcFile, new File(Constants.SCREENSHOT_FOLDER + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		
	}
}
}
