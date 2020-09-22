package com.alm.automation.reportutils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.alm.automation.actionutils.ActionUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {
	ExtentHtmlReporter extentHtmlReporter = null;
	ExtentReports extentReports = null;

	public ExtentHtmlReporter reportInitialization(String className) {
		String reportName = className + ".html";
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//ExtentReports//" + reportName);
		extentHtmlReporter.config().setDocumentTitle("Automation Execution Report");
		extentHtmlReporter.config().setReportName(reportName);
		extentHtmlReporter.config().setTheme(Theme.DARK);
		return extentHtmlReporter;
	}

	public void getResult(ITestResult iTestResult, WebDriver driver, String className, ExtentTest logger) {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(iTestResult.getName() + "- Test script FAILED !!", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(iTestResult.getThrowable() + "- Test Script FAILED !!", ExtentColor.RED));
			String screenShot = ActionUtils.getScreenShot(driver, className);
			try {
				logger.fail("Test Script Failed and screen shot is : " + logger.addScreenCaptureFromPath(screenShot));
			} catch (Exception e) {
				logger.log(Status.INFO, "Failed to Capture the screen shot or Configured wrong Screen shot path !! ");
			}
		} else if (iTestResult.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(
					iTestResult.getName() + "- Test script SKIPPED and didnt executed !!", ExtentColor.ORANGE));
		} else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(iTestResult.getName() + "- Test script PASSED !!", ExtentColor.GREEN));
		}

	}

	public static void existingReportCleanUp() {
		try {
			String path = System.getProperty("user.dir");
			String reportName = path + "\\ExtentReports";
			File file = new File(reportName);
			File[] fileList = file.listFiles();
			for (File list : fileList) {
				list.delete();
			}
		} catch (Exception exception) {

		}
	}

	public static void existingScreenShotCleanUp() {
		try {
			String path = System.getProperty("user.dir");
			String reportName = path + "/ScreenShots";
			File file = new File(reportName);
			File[] fileList = file.listFiles();
			for (File list : fileList) {
				for (File eachFile : list.listFiles()) {
					eachFile.delete();
				}
			}
		} catch (Exception exception) {

		}
	}
	
	public  ExtentHtmlReporter reportInitialization() {
		String reportName = "EnvirnomentDetails" + ".html";
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//ExtentReports//" + reportName);
		extentHtmlReporter.config().setDocumentTitle("Automation Execution Report");
		extentHtmlReporter.config().setReportName(reportName);
		extentHtmlReporter.config().setTheme(Theme.DARK);
		return extentHtmlReporter;
	}
}
