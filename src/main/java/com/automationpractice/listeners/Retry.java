package com.automationpractice.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.automationpractice.utilities.CommonUtilities;

public class Retry implements IRetryAnalyzer {

	int retryCount = 0;
	int maximumRetryCount = 2;
	CommonUtilities utils = new CommonUtilities();
	
	public boolean retry(ITestResult result) {

		if (!result.isSuccess()) {
			if (retryCount < maximumRetryCount) {
				utils.publishMessageInReports("Retrying test " + result.getName() + " with status "
						+ getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
				retryCount++;
				return true;
			}
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultStatusName = null;
		if (status == 1) {
			resultStatusName = "SUCCESS";
		}
		if (status == 2) {
			resultStatusName = "FAILED";
		}
		if (status == 3) {
			resultStatusName = "SKIPPED";
		}
		return resultStatusName;
	}

}