//package com.alm.automation.test;
//
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
//import java.util.ArrayList;
//
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.alm.automation.actionutils.AssertionUtils;
//import com.alm.automation.basepages.BaseSuite;
//import com.alm.automation.basepages.LibraryPage;
//import com.alm.automation.basepages.MRMMPage;
//import com.alm.automation.basepages.OfsaaLoginPage;
//import com.alm.automation.basepages.OfsaaWelcomePage;
//import com.alm.automation.basepages.PortfolioPage;
//import com.alm.automation.genericutils.GeneralUtils;
//import com.alm.automation.genericutils.JSONFileUtils;
//import com.alm.automation.genericutils.SleepUtils;
//import com.alm.automation.globalvariables.EnvironmentVariables;
//import com.alm.automation.globalvariables.GlobalVariable;
//import com.alm.automation.globalvariables.EnumDeclarations.CounterPartyName;
//import com.alm.automation.globalvariables.EnumDeclarations.Currency;
//import com.alm.automation.globalvariables.EnumDeclarations.EntityName;
//import com.alm.automation.globalvariables.EnumDeclarations.InstrumentType;
//import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
//import com.alm.automation.globalvariables.EnumDeclarations.WindowTitles;
//import com.alm.automation.reportutils.ExtentReportUtils;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class PortfolioTest extends BaseSuite {
//
//	private String className = null;
//	ExtentReportUtils extentReportUtils = null;
//	ExtentReports extentReports = null;
//	ExtentTest logger = null;
//
//	public PortfolioTest() {
//		super();
//	}
//
//	@BeforeTest
//	public void startReport() {
//		className = getClass().getSimpleName();
//		extentReportUtils = new ExtentReportUtils();
//		ExtentHtmlReporter extentHtmlReporter = extentReportUtils.reportInitialization(className);
//		extentReports = new ExtentReports();
//		extentReports.attachReporter(extentHtmlReporter);
//	}
//
//	@BeforeMethod
//	public void setUp() throws MalformedURLException, InterruptedException {
//		launchBrowser();
//	}
//
//
//	@Test(groups= {"SMOKE","REGRESSION"})
//	public void verifyPortfolioDefn_PositionButton_TS001_TC001(Method method) {
//		boolean status =false;
//		String methodName = method.getName();
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		status=portfolio.verifyPositionRadioButtonStatus();
//		AssertionUtils.assertBoolean(status, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_NameTextBoxEnable_TS002_TC002(Method method) {
//		String methodName = method.getName();
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_NameTextBox_SpecialChar_TS002_TC003(Method method) {
//		String specialCharErrorMsg=null;
//		String charLengthErrorMsg=null;
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.enterPortfolioName(GlobalVariable.specialCharacter);
//		portfolio.clickOnDescriptionTextBox();
//		specialCharErrorMsg=portfolio.getFormatIncorrectErrorMessageText();
//		charLengthErrorMsg=portfolio.getCharectorLengthErrorMessageText();
//		AssertionUtils.assertString(jsonFileUtils.getJsonValue("formatInvalidErrorMessage"), specialCharErrorMsg, logger);
//		AssertionUtils.assertString(jsonFileUtils.getJsonValue("charlengthMessage"), charLengthErrorMsg, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_NameTextBox_ValidLength_Null_TS002_TC004_TC005(Method method) {
//		boolean status=false;
//		String emptyErrorMsg=null;
//		String enterSomeTextErrorMsg=null;
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolioPage=libraryPage.selectPortfolioOption();
//		portfolioPage.clickOnPlusButton();
//		portfolioPage.enterPortfolioName(jsonFileUtils.getJsonValue("validlength29char"));
//		portfolioPage.clickOnDescriptionTextBox();
//		status=portfolioPage.validateEmptyErrorMessage(PortfolioPage.emptyErrorMessage);
//		AssertionUtils.assertBoolean(status, logger);
//		portfolioPage.clickOnNameTextBoxClearText();
//		portfolioPage.clickOnDescriptionTextBox();
//		emptyErrorMsg=portfolioPage.getEmptyErrorMessageText();
//		enterSomeTextErrorMsg=portfolioPage.getEnterSomeTextErrorMessageText();
//		AssertionUtils.assertString(jsonFileUtils.getJsonValue("emptyErrorMessage"), emptyErrorMsg, logger);
//		AssertionUtils.assertString(jsonFileUtils.getJsonValue("enterSomeTextErrorMessage"), enterSomeTextErrorMsg, logger);
//	}
//
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_NameTextBox_InValidLength30_TS002_TC006(Method method) {
//		String charLengthErrorMsg=null;
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("invalidLength30"));
//		portfolio.clickOnDescriptionTextBox();
//		charLengthErrorMsg=portfolio.getCharectorLengthErrorMessageText();
//		AssertionUtils.assertString(jsonFileUtils.getJsonValue("charlengthMessage"), charLengthErrorMsg, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_DescriptionTextBox_Enabled_TS002_TC007(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_DescriptionTextBox_WildChar_300Char_TS002_TC008_TC009(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		String errorMessage=null;
//		boolean status=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//		portfolio.enterPortfolioDescription(GlobalVariable.specialCharacter);
//		portfolio.clickOnNameTextBox();
//		errorMessage=portfolio.inValidDescriptionErrorMessage(PortfolioPage.invalidDescritionErrorMessage);
//		AssertionUtils.assertString(jsonFileUtils.getJsonValue("invalidDescription"), errorMessage, logger);
//		portfolio.clearPortfolioDescription();
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("300charForDescription"));
//		portfolio.clickOnNameTextBox();
//		status=portfolio.validateEmptyErrorMessage(PortfolioPage.maximumCharDescriptionError);
//		AssertionUtils.assertBoolean(status, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_DescriptionTextBox_NullValue_MaximumChar_TS002_TC010_TC011(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		String errorMessage=null;
//		boolean status=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("300charForDescription")+" Added few Char");
//		portfolio.clickOnNameTextBox();
//		errorMessage=portfolio.inValidDescriptionErrorMessage(PortfolioPage.maximumCharDescriptionError);
//		AssertionUtils.assertString(jsonFileUtils.getJsonValue("charLengthDesciptionMessage"), errorMessage, logger);
//		portfolio.clearPortfolioDescription();
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("textValueNULL"));
//		portfolio.clickOnNameTextBox();
//		status=portfolio.validateEmptyErrorMessage(PortfolioPage.maximumCharDescriptionError);
//		AssertionUtils.assertBoolean(status, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_AccessType_RadioButton_Read_ReadWrite_TS002_TC014_TC015(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		boolean beforeReadstatus=false;
//		boolean beforeReadWritestatus=false;
//		boolean afterReadstatus=false;
//		boolean afterReadWritestatus=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		beforeReadstatus=portfolio.getRadioButtonStatus(PortfolioPage.accessTypeReadRadioButton, "class");
//		beforeReadWritestatus=portfolio.getRadioButtonStatus(PortfolioPage.accessTypeReadWriteRadioButton, "class");
//		AssertionUtils.assertBoolean(beforeReadstatus, logger);
//		AssertionUtils.assertFalseBoolean(beforeReadWritestatus, logger);
//		portfolio.clickOnAccessTypeRadioButton(PortfolioPage.accessTypeReadWriteRadioButton, "Read/Write Radio");
//		afterReadstatus=portfolio.getRadioButtonStatus(PortfolioPage.accessTypeReadRadioButton, "class");
//		afterReadWritestatus=portfolio.getRadioButtonStatus(PortfolioPage.accessTypeReadWriteRadioButton, "class");
//		AssertionUtils.assertFalseBoolean(afterReadstatus, logger);
//		AssertionUtils.assertBoolean(afterReadWritestatus, logger);
//	}	
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Version_MRMMPackageFolder_TS002_TC012_TC_013(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		//		String versionID=null;
//		String folderValue=null;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		folderValue=portfolio.getFolderPackageText();
//		//		versionID=portfolio.getVersionText();
//		AssertionUtils.assertString(folderValue, jsonFileUtils.getJsonValue("folderMRMMValue"), logger);
//		//		AssertionUtils.assertInteger(1,Integer.parseInt(versionID), logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Save_Submit_TS_010_TS011_TC034_TC_035(Method method) {
//		String methodName = method.getName();
//		boolean saveButtonStatus=false;
//		boolean submitButtonStatus=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		saveButtonStatus=portfolio.verifyButton(PortfolioPage.saveButton);
//		submitButtonStatus=portfolio.verifyButton(PortfolioPage.submitButton);
//		AssertionUtils.assertBoolean(saveButtonStatus, logger);
//		AssertionUtils.assertBoolean(submitButtonStatus, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Appove_RejectPortfolioButton_TS_012_TS013_TC036_TC_037(Method method) {
//		String methodName = method.getName();
//		boolean saveButtonStatus=false;
//		boolean submitButtonStatus=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		saveButtonStatus=portfolio.verifyButton(PortfolioPage.approvePortfolioButton);
//		submitButtonStatus=portfolio.verifyButton(PortfolioPage.rejectPortfolioButton);
//		AssertionUtils.assertBoolean(saveButtonStatus, logger);
//		AssertionUtils.assertBoolean(submitButtonStatus, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_NavigationBreadCrumbs_TS_008_TC031(Method method) {
//		String methodName = method.getName();
//		boolean navigationHome=false;
//		boolean navigationPortfolioSummary=false;
//		boolean navigationNew=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		navigationHome=portfolio.verifyButton(PortfolioPage.navigationBreadCrumbsHome);
//		navigationPortfolioSummary=portfolio.verifyButton(PortfolioPage.navigationBreadCrumbsPortfolioSummary);
//		navigationNew=portfolio.verifyButton(PortfolioPage.navigationBreadCrumbsNew);
//		AssertionUtils.assertBoolean(navigationHome, logger);
//		AssertionUtils.assertBoolean(navigationPortfolioSummary, logger);
//		AssertionUtils.assertBoolean(navigationNew, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_DimentionsRadioButtonOptions_TS_014_TC038(Method method) {
//		String methodName = method.getName();
//		boolean availablevalues=false;
//		boolean selectedvalues=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnDimentionRadioButton();
//		availablevalues=portfolio.verifyButton(PortfolioPage.availableHierarchies);
//		selectedvalues=portfolio.verifyButton(PortfolioPage.selectedValuesHierarchies);
//		AssertionUtils.assertBoolean(availablevalues, logger);
//		AssertionUtils.assertBoolean(selectedvalues, logger);
//	}
//
//	/* Portfolio Dimension Based Test Script completed */
//
//	/* Portfolio Position Based Test Script Started */
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_AvailableFilter_ApplyAndReset_TS003_TC017_TC018(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		String availablePositionFilter=null;
//		boolean applyButton=false;
//		boolean resetButton=false;
//		boolean instrumentType=false;
//		boolean entityName=false;
//		boolean counterpartyName=false;
//		boolean currency=false;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		portfolio.clickOnPositionPortfolioFilterButton();
//		availablePositionFilter=portfolio.getText(PortfolioPage.portfolioAvailablePositionFilterHeaders);
//		applyButton=portfolio.verifyButton(PortfolioPage.portfolioPositionFilterApplyButton);
//		resetButton=portfolio.verifyButton(PortfolioPage.portfolioPositionFilterResetButton);
//		instrumentType=portfolio.verifyButton(PortfolioPage.portfolioPositionFilterInstrumentType);
//		currency=portfolio.verifyButton(PortfolioPage.portfolioPositionFilterCurrency);
//		entityName=portfolio.verifyButton(PortfolioPage.portfolioPositionFilterEntityName);
//		counterpartyName=portfolio.verifyButton(PortfolioPage.portfolioPositionFilterCounterPartyName);
//		AssertionUtils.assertString(availablePositionFilter, jsonFileUtils.getJsonValue("availablePositionFilter"), logger);
//		AssertionUtils.assertBoolean(applyButton, logger);
//		AssertionUtils.assertBoolean(resetButton, logger);
//		AssertionUtils.assertBoolean(instrumentType, logger);
//		AssertionUtils.assertBoolean(currency, logger);
//		AssertionUtils.assertBoolean(entityName, logger);
//		AssertionUtils.assertBoolean(counterpartyName, logger);
//	}	
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_AvailableFilter_InstrumentType_EntityName_CounterParty_Currency_Count_TS003_TC019_TC020_TC021_TC022(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		boolean status=false;
//		int instrumentType;
//		int entityName;
//		int counterpartyName;
//		int currency;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		portfolio.clickOnPositionPortfolioFilterButton();
//		instrumentType=portfolio.getListOfElementCount(PortfolioPage.portfolioPositionFilterInstrumentTypeListCount, "Instrument Type");
//		entityName=portfolio.getListOfElementCount(PortfolioPage.portfolioPositionFilterEntityNameListCount, "Entity Name");
//		counterpartyName=portfolio.getListOfElementCount(PortfolioPage.portfolioPositionFilterCounterPartyNameListCount, "CounterParty Name");
//		currency=portfolio.getListOfElementCount(PortfolioPage.portfolioPositionFilterCurrencyListCount, "Currency");
//		if(instrumentType > 0 && entityName > 0 && counterpartyName > 0 && currency >0) {
//			status=true;
//		}else {
//			status=false;
//		}
//		AssertionUtils.assertBoolean(status, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_AvailableFilter_Reset_TS003_TC024(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		boolean instrumentTypeStatus;
//		boolean entityNameStatus;
//		boolean counterpartyNameStatus;
//		boolean currencyStatus;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		portfolio.enterPortfolioName(jsonFileUtils.getJsonValue("validName"));
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		portfolio.clickOnPositionPortfolioFilterButton();
//		portfolio.clickOnInstrumentType();
//		portfolio.selectInstrumentType("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		portfolio.clickOnInstrumentType();
//		portfolio.clickOnEntityName();
//		portfolio.selectInstrumentType("Entity Name",EntityName.MISSING.getValue());
//		portfolio.clickOnEntityName();
//		portfolio.clickOnCounterPartyName();
//		portfolio.selectInstrumentType("Counterparty Name",CounterPartyName.MISSING.getValue());
//		portfolio.clickOnCounterPartyName();
//		portfolio.clickOnCurrency();
//		portfolio.selectInstrumentType("Currency",Currency.USDOLLAR.getValue());
//		portfolio.clickOnCurrency();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnFilterResetButton();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		instrumentTypeStatus=portfolio.verifyAppliedFilterStatus("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		entityNameStatus=portfolio.verifyAppliedFilterStatus("Entity Name",EntityName.MISSING.getValue());
//		counterpartyNameStatus=portfolio.verifyAppliedFilterStatus("Counterparty Name",CounterPartyName.MISSING.getValue());
//		currencyStatus=portfolio.verifyAppliedFilterStatus("Currency",Currency.USDOLLAR.getValue());
//		AssertionUtils.assertFalseBoolean(instrumentTypeStatus, logger);
//		AssertionUtils.assertFalseBoolean(entityNameStatus, logger);
//		AssertionUtils.assertFalseBoolean(counterpartyNameStatus, logger);
//		AssertionUtils.assertFalseBoolean(currencyStatus, logger);
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_AvailableFilter_Apply_TS003_TC023(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		ArrayList<String> values=null;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		String portfolioName=jsonFileUtils.getJsonValue("validName")+"_"+SleepUtils.uniqueValue();
//		portfolio.enterPortfolioName(portfolioName);
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		portfolio.clickOnPositionPortfolioFilterButton();
//		portfolio.clickOnInstrumentType();
//		portfolio.selectInstrumentType("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		portfolio.clickOnInstrumentType();
//		portfolio.clickOnCurrency();
//		portfolio.selectInstrumentType("Currency",Currency.USDOLLAR.getValue());
//		portfolio.clickOnCurrency();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnFilterApplyButton();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		values=portfolio.getAvailablePositionsFirstRowRecords();
//		for(int i=0 ;i<values.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(values.get(i), logger);
//		}
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_AvailablePositions_Column_Values_TS003_TC025_TC_026(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		ArrayList<String> values=null;
//		ArrayList<String> columnValue=null;
//		String availablePositionBefore=null;
//		String availablePositionAfter=null;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		String portfolioName=jsonFileUtils.getJsonValue("validName")+"_"+SleepUtils.uniqueValue();
//		portfolio.enterPortfolioName(portfolioName);
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		availablePositionBefore=portfolio.getAttributeValue(PortfolioPage.AvailablePositionBeforeFilter,"style");
//		if(availablePositionBefore.trim().contains("block;")) {
//			AssertionUtils.assertBoolean(true, logger);
//		}else {
//			AssertionUtils.assertBoolean(false, logger);
//		}
//		portfolio.clickOnPositionPortfolioFilterButton();
//		portfolio.clickOnInstrumentType();
//		portfolio.selectInstrumentType("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		portfolio.clickOnInstrumentType();
//		portfolio.clickOnCurrency();
//		portfolio.selectInstrumentType("Currency",Currency.USDOLLAR.getValue());
//		portfolio.clickOnCurrency();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnFilterApplyButton();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		availablePositionAfter=portfolio.getAttributeValue(PortfolioPage.AvailablePositionBeforeFilter,"style");
//		if(availablePositionAfter.trim().contains("block;")) {
//			AssertionUtils.assertBoolean(false, logger);
//		}else {
//			AssertionUtils.assertBoolean(true, logger);
//		}
//		columnValue=portfolio.verfiyAvailablePositionsColumnValues();
//		for(int i=0 ;i<columnValue.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(columnValue.get(i), logger);
//		}
//		values=portfolio.getAvailablePositionsFirstRowRecords();
//		for(int i=0 ;i<values.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(values.get(i), logger);
//		}
//	}
//	
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_SelectedPosition_Column_Add_DataBase_TS004_TS_005_TC027_TC_028_TC_029(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		ArrayList<String> values=null;
//		ArrayList<String> columnValue=null;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();  
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		String portfolioName=jsonFileUtils.getJsonValue("validName")+"_"+SleepUtils.uniqueValue();
//		portfolio.enterPortfolioName(portfolioName);
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		portfolio.clickOnPositionPortfolioFilterButton();
//		portfolio.clickOnInstrumentType();
//		portfolio.selectInstrumentType("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		portfolio.clickOnInstrumentType();
//		portfolio.clickOnCurrency();
//		portfolio.selectInstrumentType("Currency",Currency.USDOLLAR.getValue());
//		portfolio.clickOnCurrency();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnFilterApplyButton();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnAvailablePositionCheckBox();
//		portfolio.clickOnAvailablePositionsAddButton();
//		columnValue=portfolio.verfiySelectedPositionsColumnValues();
//		for(int i=0 ;i<columnValue.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(columnValue.get(i), logger);
//		}
//		values=portfolio.getSelectedPositionsFirstRowRecords();
//		for(int i=0 ;i<values.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(values.get(i), logger);
//		}
//	}
//	
//	//Database validation pending
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_SelectedPosition_Column_Add_DataBase_TS004_TS_005_TC027_TC_028_TC_029_TC_30(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		ArrayList<String> values=null;
//		ArrayList<String> columnValue=null;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();  
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		String portfolioName=jsonFileUtils.getJsonValue("validName")+"_"+SleepUtils.uniqueValue();
//		portfolio.enterPortfolioName(portfolioName);
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		portfolio.clickOnPositionPortfolioFilterButton();
//		portfolio.clickOnInstrumentType();
//		portfolio.selectInstrumentType("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		portfolio.clickOnInstrumentType();
//		portfolio.clickOnCurrency();
//		portfolio.selectInstrumentType("Currency",Currency.USDOLLAR.getValue());
//		portfolio.clickOnCurrency();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnFilterApplyButton();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnAvailablePositionCheckBox();
//		portfolio.clickOnAvailablePositionsAddButton();
//		columnValue=portfolio.verfiySelectedPositionsColumnValues();
//		for(int i=0 ;i<columnValue.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(columnValue.get(i), logger);
//		}
//		values=portfolio.getSelectedPositionsFirstRowRecords();
//		for(int i=0 ;i<values.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(values.get(i), logger);
//		}
//	}
//
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_SelectedPosition_Single_Multi_Values_Remove_TS006_TC031_TC_032_TC_033(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		ArrayList<String> values=null;
//		ArrayList<Boolean> status=null;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();  
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		String portfolioName=jsonFileUtils.getJsonValue("validName")+"_"+SleepUtils.uniqueValue();
//		portfolio.enterPortfolioName(portfolioName);
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		portfolio.clickOnPositionPortfolioFilterButton();
//		portfolio.clickOnInstrumentType();
//		portfolio.selectInstrumentType("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		portfolio.clickOnInstrumentType();
//		portfolio.clickOnCurrency();
//		portfolio.selectInstrumentType("Currency",Currency.USDOLLAR.getValue());
//		portfolio.clickOnCurrency();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnFilterApplyButton();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnAvailablePositionCheckBox(PortfolioPage.firstAvailablePostionsCheckBox);
//		portfolio.clickOnAvailablePositionCheckBox(PortfolioPage.secondAvailablePostionsCheckBox);
//		portfolio.clickOnAvailablePositionCheckBox(PortfolioPage.thirdAvailablePostionsCheckBox);
//		portfolio.clickOnAvailablePositionsAddButton();
//		values=portfolio.getSelectedPositionsAccountName();
//		for(int i=0 ;i<values.size()-1 ;i++) {
//			AssertionUtils.assertNotNull(values.get(i), logger);
//		}
//		portfolio.clickOnSelectionPositionCheckBox(PortfolioPage.firstSelectedPostionsCheckBox);
//		portfolio.clickOnRemoveButton();
//		portfolio.clickOnSelectionPositionCheckBox(PortfolioPage.firstSelectedPostionsCheckBox);
//		portfolio.clickOnSelectionPositionCheckBox(PortfolioPage.secondSelectedPostionsCheckBox);
//		portfolio.clickOnRemoveButton();
//		status=portfolio.getSelectedPositionsAccountNameStatus();
//		for(int i=0 ;i<status.size()-1 ;i++) {
//			AssertionUtils.assertBoolean(status.get(i), logger);
//		}
//	}
//	
//	@Test(groups= {"SmokeTestScript","RegressionTestScript"})
//	public void verifyPortfolioDefn_Position_Pagiation_Min_Max_Spec_DefaultValue_TS007_TC034_TC_035_TC_036_TC_037_TC_038(Method method) {
//		JSONFileUtils jsonFileUtils=new JSONFileUtils(className);
//		String methodName = method.getName();
//		ArrayList<String> values=null;
//		ArrayList<Boolean> status=null;
//		logger = extentReports.createTest(methodName);
//		logger.log(Status.INFO, methodName + " script Execution Started !!!");
//		OfsaaLoginPage ofsaaLoginPage = new OfsaaLoginPage(logger);
//		OfsaaWelcomePage ofsaaWelcomePage = ofsaaLoginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,EnvironmentVariables.PASSWORD);
//		String actualTitle = ofsaaLoginPage.getPageTitle();
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
//		ofsaaWelcomePage.clickOnMRMMOption();
//		ofsaaWelcomePage.clickOnNavigationMRMMOption();  
//		MRMMPage mRMMPage = ofsaaWelcomePage.clickOnMRMMListMRMM();
//		mRMMPage.clickOnMRMMOptionButton();
//		LibraryPage libraryPage =mRMMPage.clickOnMRMMLibraryListButton();
//		PortfolioPage portfolio=libraryPage.selectPortfolioOption();
//		portfolio.clickOnPlusButton();
//		portfolio.clickOnPositionRadioButton();
//		String portfolioName=jsonFileUtils.getJsonValue("validName")+"_"+SleepUtils.uniqueValue();
//		portfolio.enterPortfolioName(portfolioName);
//		portfolio.enterPortfolioDescription(jsonFileUtils.getJsonValue("validDescription"));
//		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
//		portfolio.clickOnPositionPortfolioFilterButton();
//		portfolio.clickOnInstrumentType();
//		portfolio.selectInstrumentType("Instrument Type",InstrumentType.AMORTIZINGBOND.getValue());
//		portfolio.clickOnInstrumentType();
//		portfolio.clickOnCurrency();
//		portfolio.selectInstrumentType("Currency",Currency.USDOLLAR.getValue());
//		portfolio.clickOnCurrency();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//		portfolio.clickOnFilterApplyButton();
//		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
//	}
//
//
//
//	@AfterMethod
//	public void getResultAndTearDown(ITestResult iTestResult) {
//		if (iTestResult.getStatus() == ITestResult.SUCCESS) {
//			logger.log(Status.INFO, iTestResult.getName() + " test script Execution Ended !!!");
//			driver.quit();
//		} else {
//			extentReportUtils.getResult(iTestResult, driver, className, logger);
//			driver.quit();
//		}
//	}
//
//
//
//	@AfterTest
//	public void endReport() {
//		extentReports.flush();
//	}
//
//}
//
