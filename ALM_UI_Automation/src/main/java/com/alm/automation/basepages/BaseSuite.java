package com.alm.automation.basepages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.alm.automation.genericutils.GeneralUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnvironmentVariables;
import com.alm.automation.globalvariables.GlobalVariable;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.alm.automation.reportutils.EnvironmentVariableReport;
import com.alm.automation.reportutils.ExtentReportUtils;
import com.aventstack.extentreports.ExtentReports;

public class BaseSuite {
	public static Properties properties;
	public static WebDriver driver;
	public ExtentReports extentReports;

	@BeforeSuite
	public void logsCleanUp() {
		EnvironmentVariableReport envirnomentVariableReport =new EnvironmentVariableReport();
		ExtentReportUtils.existingReportCleanUp();
		ExtentReportUtils.existingScreenShotCleanUp();
		envirnomentVariableReport.environmentVariableReport();
	}

	public static void launchBrowser() throws MalformedURLException, InterruptedException {
		if (EnvironmentVariables.BROWSER.equalsIgnoreCase(GlobalVariable.CHROMEBROWSERNAME)) {
			ChromeOptions chromeOptions =new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			System.setProperty(GlobalVariable.CHROMEDRIVER, GlobalVariable.CHROMEDRIVERPATH);
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(GlobalVariable.PAGELOADTIMEINSEC, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(GlobalVariable.IMPLICITTIMEINSEC, TimeUnit.SECONDS);
			waitForPageLoaded();
			driver.get(EnvironmentVariables.APPLICATION_URL);
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		} else if (properties.getProperty(EnvironmentVariables.BROWSER).equalsIgnoreCase("firefox")) {

		} else if (properties.getProperty(EnvironmentVariables.BROWSER).equalsIgnoreCase("IE")) {

		}

	}

	public BaseSuite() {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("env.properties"));
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void closeOpenedBrowser() {
		if (driver != null) {
			driver.quit();
			GeneralUtils.killChromeProcess();
		}

	}
	
	public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}


