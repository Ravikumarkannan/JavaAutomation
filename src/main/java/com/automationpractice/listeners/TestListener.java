package com.automationpractice.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationpractice.testbase.TestBase;
import com.automationpractice.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.automationpractice.utilities.CommonUtilities;

public class TestListener extends TestBase implements ITestListener {

	ExtentReports report;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		ExtentTest test = report.createTest(testCaseName);
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "Test case " + result.getMethod().getMethodName() + " is Passed";
		Markup mn = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, mn);
	}

	public void onTestFailure(ITestResult result) {
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("Exception occured, click to see details: " + exceptionMessage);

		CommonUtilities utils = new CommonUtilities();
		utils.captureScreenShot(getDriver());

		String logText = "Test case " + result.getMethod().getMethodName() + " is Failed";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		report = ExtentManager.setupExtentReport();

	}

	public void onFinish(ITestContext context) {
		if (report != null) {
			report.flush();
		}

	}
}
