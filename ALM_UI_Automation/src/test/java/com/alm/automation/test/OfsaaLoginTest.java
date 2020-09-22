package com.alm.automation.test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alm.automation.actionutils.AssertionUtils;
import com.alm.automation.basepages.BaseSuite;
import com.alm.automation.basepages.OfsaaLoginPage;
import com.alm.automation.genericutils.GeneralUtils;
import com.alm.automation.genericutils.JSONFileUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnvironmentVariables;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.alm.automation.globalvariables.EnumDeclarations.WindowTitles;
import com.alm.automation.reportutils.ExtentReportUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class OfsaaLoginTest extends BaseSuite {

	ExtentReportUtils extentReportUtils = null;
	ExtentReports extentReports = null;
	ExtentTest logger = null;
	private String className = getClass().getSimpleName();
	private JSONFileUtils jsonFileUtils = new JSONFileUtils(getClass().getSimpleName());

	public OfsaaLoginTest() {
		super();
	}

	@BeforeTest
	public void startReport() {
		extentReportUtils = new ExtentReportUtils();
		ExtentHtmlReporter extentHtmlReporter = extentReportUtils.reportInitialization(className);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		launchBrowser();
	}

	@Test()
	public void loginTest(Method method) {
		String env = jsonFileUtils.getJsonValue("testusername");
		System.out.println(env);
		String methodName = method.getName();
		logger = extentReports.createTest(methodName);
		logger.log(Status.INFO, methodName + " script Execution Started !!!");
		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
		ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME, EnvironmentVariables.PASSWORD);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String actualTitle = ofsaaLoginPage.getPageTitle();
		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
		logger.log(Status.INFO, methodName + " script Execution Ended !!!");
	}

	/*@Test
	public void loginTest1(Method method) {
		String methodName = method.getName();
		logger = extentReports.createTest(methodName);
		logger.log(Status.INFO, methodName + " script Execution Started !!!");
		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
		ofsaaLoginPage.ofsaaLogin(properties.getProperty("env.username"), properties.getProperty("env.password"));
		String actualTitle = ofsaaLoginPage.getPageTitle();
		AssertionUtils.assertString(actualTitle, "Oracle Financial Services Analytical Applications", logger);
		logger.log(Status.INFO, methodName + " script Execution Ended !!!");
	}*/

	
	
	
	@AfterMethod
	public void getResultAndTearDown(ITestResult iTestResult) {
		if (iTestResult.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.INFO, iTestResult.getName() + " test script Execution Ended !!!");
			driver.quit();
		} else {
			extentReportUtils.getResult(iTestResult, driver, className, logger);
			driver.quit();
			GeneralUtils.killChromeProcess();
		}
	}

	@AfterTest
	public void endReport() {
		extentReports.flush();
	}

}
