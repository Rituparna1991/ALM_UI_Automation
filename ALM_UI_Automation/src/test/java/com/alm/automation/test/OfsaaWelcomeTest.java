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
import com.alm.automation.basepages.OfsaaWelcomePage;
import com.alm.automation.globalvariables.EnvironmentVariables;
import com.alm.automation.globalvariables.EnumDeclarations.WindowTitles;
import com.alm.automation.reportutils.ExtentReportUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class OfsaaWelcomeTest extends BaseSuite {

	private String className = null;
	ExtentReportUtils extentReportUtils = null;
	ExtentReports extentReports = null;
	ExtentTest logger = null;

	public OfsaaWelcomeTest() {
		super();
	}

	@BeforeTest
	public void startReport() {
		className = getClass().getSimpleName();
		extentReportUtils = new ExtentReportUtils();
		ExtentHtmlReporter extentHtmlReporter = extentReportUtils.reportInitialization(className);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		launchBrowser();
	}

	@Test
	public void loginTest1(Method method) {
		String methodName = method.getName();
		logger = extentReports.createTest(methodName);
		logger.log(Status.INFO, methodName + " script Execution Started !!!");
		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,
				EnvironmentVariables.PASSWORD);
		String actualTitle = ofsaaLoginPage.getPageTitle();
		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
		ofsaaWelcomePage.clickonNavigate_to_ALM();
		//ofsaaWelcomePage.closeAlert();
		//ofsaaWelcomePage.clickOnMRMMOption();
		//ofsaaWelcomePage.logOutApllication();

	}

	@AfterMethod
	public void getResultAndTearDown(ITestResult iTestResult) {
		if (iTestResult.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.INFO, iTestResult.getName() + " test script Execution Ended !!!");
			if (driver != null)
				driver.quit();
		} else {
			extentReportUtils.getResult(iTestResult, driver, className, logger);
			driver.quit();
		}
	}

	@AfterTest
	public void endReport() {
		extentReports.flush();
	}

}
