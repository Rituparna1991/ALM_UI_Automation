package com.alm.automation.reportutils;

import com.alm.automation.globalvariables.EnvironmentVariables;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class EnvironmentVariableReport {
	private ExtentReportUtils extentReportUtils=new ExtentReportUtils();
	private ExtentHtmlReporter extentHtmlReporter;
	private ExtentReports extentReports= null;
	ExtentTest extentTest;

	public void environmentVariableInitialization() {
		extentHtmlReporter=extentReportUtils.reportInitialization();
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}

	public void environmentVariableReport() {
		environmentVariableInitialization();
		extentTest= extentReports.createTest("Envirnoment Variable Details");
		extentTest.log(Status.INFO, "Application URL : "+EnvironmentVariables.APPLICATION_URL+"");
		extentTest.log(Status.INFO, "Browser : "+EnvironmentVariables.BROWSER+"");
		extentTest.log(Status.INFO, "User Name : "+EnvironmentVariables.USER_NAME+"");
		extentTest.log(Status.INFO, "Password : "+EnvironmentVariables.PASSWORD+"");
		extentTest.log(Status.INFO, "DataBase Server IP : "+EnvironmentVariables.DATABASEIP+"");
		extentTest.log(Status.INFO, "DataBase Server Database : "+EnvironmentVariables.DATABASESCHEMA+"");
		extentTest.log(Status.INFO, "DataBase Server Port : "+EnvironmentVariables.DATABASEPORT+"");
		extentTest.log(Status.INFO, "DataBase Server Config UserName : "+EnvironmentVariables.DATABASECONFIGUSERNAME+"");
		extentTest.log(Status.INFO, "DataBase Server Config Password : "+EnvironmentVariables.DATABASECONFIGPASSWORD+"");
		extentTest.log(Status.INFO, "DataBase Server Atomic UserName : "+EnvironmentVariables.DATABASECONFIGUSERNAME+"");
		extentTest.log(Status.INFO, "DataBase Server Atomic Password : "+EnvironmentVariables.DATABASEATOMICPASSWORD+"");
		extentTest.log(Status.INFO, "DataBase Driver Path : "+EnvironmentVariables.DATABASEDRIVERPATH+"");
		extentReports.flush();
	}
}
