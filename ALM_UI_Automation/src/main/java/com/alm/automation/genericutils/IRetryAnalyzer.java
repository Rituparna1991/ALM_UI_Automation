package com.alm.automation.genericutils;

import org.testng.ITestResult;

public interface IRetryAnalyzer {

	/***
	 * 
	 * @param result
	 * @return
	 */

	public boolean retry(ITestResult result);

}
