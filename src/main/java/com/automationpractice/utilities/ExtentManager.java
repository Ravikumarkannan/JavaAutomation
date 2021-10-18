package com.automationpractice.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.automationpractice.constants.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports extent;

	public static ExtentReports setupExtentReport() {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		ExtentSparkReporter htmlReports_All = reports_All(
				Constants.EXTENT_REPORT_FOLDER + "Only_ALL_" + actualDate + ".html");
		ExtentSparkReporter htmlReports_Fail = reports_Failed(
				Constants.EXTENT_REPORT_FOLDER + "Only_FAILED_" + actualDate + "html");
		ExtentSparkReporter htmlReports_Pass = reports_Passed(
				Constants.EXTENT_REPORT_FOLDER + "Only_PASSED_" + actualDate + ".html");
		ExtentSparkReporter htmlReports_Skip = reports_Skipped(
				Constants.EXTENT_REPORT_FOLDER + "Only_SKIPPPED_" + actualDate + ".html");

		extent = new ExtentReports();
		extent.setSystemInfo("Practice Test", "Automation");
		extent.attachReporter(htmlReports_All, htmlReports_Fail, htmlReports_Pass, htmlReports_Skip);
		return extent;
	}

	private static ExtentSparkReporter reports_All(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		htmlReporter.config().setDocumentTitle("Automation Test Reports - ALL ");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName("Automation Test Results - ALL");
		return htmlReporter;
	}

	private static ExtentSparkReporter reports_Failed(String fileName) {
		ExtentSparkReporter htmlReporter_Failed = new ExtentSparkReporter(fileName).filter().statusFilter()
				.as(new Status[] { Status.FAIL }).apply();
		htmlReporter_Failed.config().setDocumentTitle("Automation Test Reports - FAILED ");
		htmlReporter_Failed.config().setEncoding("UTF-8");
		htmlReporter_Failed.config().setTheme(Theme.STANDARD);
		htmlReporter_Failed.config().setReportName("Automation Test Results - FAILED");
		return htmlReporter_Failed;
	}

	private static ExtentSparkReporter reports_Passed(String fileName) {
		ExtentSparkReporter htmlReporter_Passed = new ExtentSparkReporter(fileName).filter().statusFilter()
				.as(new Status[] { Status.PASS }).apply();
		htmlReporter_Passed.config().setDocumentTitle("Automation Test Reports - PASSED ");
		htmlReporter_Passed.config().setEncoding("UTF-8");
		htmlReporter_Passed.config().setTheme(Theme.STANDARD);
		htmlReporter_Passed.config().setReportName("Automation Test Results - PASSED");
		return htmlReporter_Passed;
	}

	private static ExtentSparkReporter reports_Skipped(String fileName) {
		ExtentSparkReporter htmlReporter_Skipped = new ExtentSparkReporter(fileName).filter().statusFilter()
				.as(new Status[] { Status.SKIP }).apply();
		htmlReporter_Skipped.config().setDocumentTitle("Automation Test Reports - SKIPPED ");
		htmlReporter_Skipped.config().setEncoding("UTF-8");
		htmlReporter_Skipped.config().setTheme(Theme.STANDARD);
		htmlReporter_Skipped.config().setReportName("Automation Test Results - SKIPPED");
		return htmlReporter_Skipped;
	}
}
