package com.alm.automation.genericutils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 3;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
