package com.alm.automation.test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.alm.automation.actionutils.ActionUtils;
import com.alm.automation.actionutils.AssertionUtils;
//import com.alm.automation.actionutils.Log;
import com.alm.automation.basepages.BaseSuite;
import com.alm.automation.basepages.OfsaaLoginPage;
import com.alm.automation.basepages.OfsaaWelcomePage;
import com.alm.automation.basepages.PrepaymentsPage;
import com.alm.automation.genericutils.JSONFileUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.alm.automation.globalvariables.EnumDeclarations.WindowTitles;
import com.alm.automation.globalvariables.EnvironmentVariables;
import com.alm.automation.reportutils.ExtentReportUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * PrePayments test cases
 * @author rhota
 *
 */

public class PrepaymentsTest extends BaseSuite {
	private String className = null;
	ExtentReportUtils extentReportUtils = null;
	ExtentReports extentReports = null;
	private ExtentTest logger;
    Logger Log = LogManager.getLogger(PrepaymentsTest.class);

	
	private static final String name = "Auto_" + new ActionUtils().randomNumber();
	private static final String description = name + "_desc";
	private static final String name1 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description1 = name1 + "_desc";
	private static final String name2 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description2 = name2 + "_desc";
	private static final String name3 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description3 = name3 + "_desc";
	private static final String name4 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description4 = name4 + "_desc";
	private static final String name5 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description5 = name5 + "_desc";
	private static final String name6 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description6 = name6 + "_desc";
	private static final String name7 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description7 = name7 + "_desc";
	private static final String name8 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description8 = name8 + "_desc";
	private static final String name9 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description9 = name9 + "_desc";
	private static final String name10 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description10 = name10 + "_desc";
	private static final String name11 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description11 = name11 + "_desc";
	private static final String name12 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description12 = name12 + "_desc";
	private static final String name13 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description13 = name13 + "_desc";
	private static final String name14 = "Auto_" + new ActionUtils().randomNumber();
	private static final String description14 = name14 + "_desc";
	//private static final String name15 = "Auto_" + new ActionUtils().randomNumber();
	//private static final String description15 = name15 + "_desc";
	
	private static final String editedName = name + "_edited";
	private static final String copiedName = name2 + "_copied";

	public PrepaymentsTest() {
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

	/**
	 * Launch Browser
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@BeforeClass()
	public void setUp() throws MalformedURLException, InterruptedException, IllegalArgumentException {
		launchBrowser();
		String methodName = Method.class.getName();
		logger = extentReports.createTest(methodName);
		logger.log(Status.INFO, methodName + " script Execution Started !!!");
		OfsaaLoginPage loginPage = new OfsaaLoginPage(logger);
		OfsaaWelcomePage welcomePage = loginPage.ofsaaLogin(EnvironmentVariables.USER_NAME,
				EnvironmentVariables.PASSWORD);
		String actualTitle = loginPage.getPageTitle();
		AssertionUtils.assertString(actualTitle, WindowTitles.WELCOMEPAGETITLE.getValue(), logger);
	}

	/**
	 * Navigate to Prepayments
	 * 
	 * @param method
	 * @throws Exception
	 */
	@BeforeMethod()
	public void login(Method method) throws Exception {

		OfsaaWelcomePage welcomePage = new OfsaaWelcomePage(logger);
		welcomePage.clickonNavigate_to_ALM();
		welcomePage.clickonNavigate_to_ALMList();
		welcomePage.clickonNavigate_to_ALMAssumptionSpecification();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		logger.log(Status.INFO, "Global body not displayed");
		logger.info("Click on prepayments==================");
		prepaymentspage.clickOnPrepayments();
		boolean globalbody = prepaymentspage.GlobalbodyisDisplayed();
		if (globalbody == true) {
			prepaymentspage.clickNavigationtoRightPanel();
		} else {
			logger.log(Status.INFO, "Global body not displayed");
		}
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
	}

	/**
	* Come back to home page of ALM 
	*/
	@AfterMethod()
	public void clickToHome() {
		OfsaaWelcomePage welcomePage = new OfsaaWelcomePage(logger);
		welcomePage.clickAppNavigation();
		welcomePage.clickHomeIcon();
	}

	/**
	 * 
	 * @param iTestResult
	 */
	@AfterClass()
	public void closeWindow() {
		/*
		 * if (ITestResult.getStatus() == ITestResult.SUCCESS) { logger.log(Status.INFO,
		 * iTestResult.getName() + " test script Execution Ended !!!"); if (driver !=
		 * null) driver.quit(); } else { extentReportUtils.getResult(iTestResult,
		 * driver, className, logger); driver.quit(); } extentReports.flush();
		 */
		driver.quit();
	}

	/**
	 * 
	 */
	@AfterTest()
	public void endReport() {
		extentReports.flush();
	}

	@Test(enabled = false, priority = 1, groups = "prePayments")
	public void verify_Status() {

		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		Log.info("================info==============");
		Log.fatal("fatal===============");
		Log.error("============error");
		Log.warn("====warn=======");
		System.out.println(prepaymentspage.Addicon.getAttribute("data-bind"));
		softAssert.assertTrue(prepaymentspage.Addicon.getAttribute("data-bind").contains("getDisabledToolMenuImages"));
		softAssert.assertTrue(prepaymentspage.Addicon.isEnabled(), "Add icon is disabled");
		softAssert.assertTrue(prepaymentspage.Edit_icon.isEnabled(), "Edit icon is enabled");
}

	/**
	 * Create New Prepayments Rule with Donotcalculate
	 * 
	 * @throws Exception
	 */
	@Test(enabled = true, priority = 2, groups = "prePayments")
	public void addDoNotCalculate() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);

		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		ActionUtils.switchWindowUsingCount(driver);
		logger.info("Window switched");
		prepaymentspage.enterName(name);
		logger.info("Name is" + name);
		prepaymentspage.enterDescription(description);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.clickOnAddProductButton();
		ActionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method1"));
		prepaymentspage.click_Apply();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Edit Prepayment Rule Name and Description
	 * 
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 3,groups = "prePayments")
	public void editPrepayments() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		ActionUtils actionUtils = new ActionUtils();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);

		prepaymentspage.SearchwithName(name);
		prepaymentspage.clicksearchicon();

		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name), String.format("No Results Found"));
		prepaymentspage.click_search_Result_Checkbox();
		prepaymentspage.click_Edit_icon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.clear_name();
		prepaymentspage.enterName(editedName);
		prepaymentspage.clear_description();
		prepaymentspage.enterDescription(description + "_edited");
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(PrepaymentsPage.mainIframeID);
		prepaymentspage.SearchwithName(editedName);
		prepaymentspage.clicksearchicon();
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(editedName), String.format("Results Not Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Edit Product Definition
	 * 
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 4, groups = "prePayments")
	public void editProdDefinition() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		ActionUtils actionUtils = new ActionUtils();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);

		prepaymentspage.SearchwithName(editedName);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(editedName), String.format("No Results Found"));
		prepaymentspage.click_search_Result_Checkbox();
		prepaymentspage.click_Edit_icon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		/*prepaymentspage.click_AssumptionList();
		prepaymentspage.select_Dimension_Member_Name(jsonFileUtils.getJsonValue("Dimension_Name_dropdown"));
		prepaymentspage.Enter_Dimension_Member_ProdName(jsonFileUtils.getJsonValue("Product_Name"));
		prepaymentspage.click_Search_Member();
		softAssert.assertEquals(jsonFileUtils.getJsonValue("Product_Name"), prepaymentspage.getText_SearchedMember(),
				String.format("Member not found"));
		softAssert.assertEquals(jsonFileUtils.getJsonValue("Cal_Method1"), prepaymentspage.getText_Defined_Method(),
				String.format("Defined Method does not match"));
		prepaymentspage.click_Assumption_list_Result();*/
		prepaymentspage.click_Edit_icon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method2"));
		prepaymentspage.clear_Percent();
		prepaymentspage.enter_Percent(jsonFileUtils.getJsonValue("Constant_Percent"));
		prepaymentspage.click_Apply();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(editedName);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(editedName), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create New Prepayments Rule with Constant
	 * 
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 5, groups = "prePayments")
	public void addConstant() throws Exception {

		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		ActionUtils actionUtils = new ActionUtils();
		SoftAssert softAssert = new SoftAssert();

		prepaymentspage.clickAddicon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name1);
		prepaymentspage.enterDescription(description1);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.clickOnAddProductButton();
		prepaymentspage.clickAddicon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method2"));
		prepaymentspage.clear_Percent();
		prepaymentspage.enter_Percent(jsonFileUtils.getJsonValue("Constant_Percent"));
		prepaymentspage.click_Apply();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name1);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name1), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * View Prepayment Rule
	 * 
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 6,  groups = "prePayments")
	public void view() {

		SoftAssert softAssert = new SoftAssert();
		ActionUtils actionUtils = new ActionUtils();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);

		prepaymentspage.SearchwithName(name1);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name1), String.format("No Results Found"));
		prepaymentspage.click_search_Result_Checkbox();
		prepaymentspage.click_Veiw_Icon();
		actionUtils.switchWindowUsingCount(driver);
		softAssert.assertEquals(jsonFileUtils.getJsonValue("Disable_status_Name"),
				prepaymentspage.getAttribute_NameField(), String.format("Field is enabled"));
		softAssert.assertEquals(prepaymentspage.getText_NameField(), name1, String.format("Name does not match"));
		softAssert.assertEquals(jsonFileUtils.getJsonValue("Disable_status_Description"),
				prepaymentspage.getAttribute_DescriptionField(), String.format("Field is enabled"));
		softAssert.assertEquals(prepaymentspage.getText_DescriptionField(), description1,
				String.format("Description does not match"));
		prepaymentspage.clickClose();
		actionUtils.switchWindowUsingCount(driver);
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create New Prepayments Rule with Prepaymentmodel
	 * 
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 7, groups = "prePayments")
	public void addPrepaymentModel() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		ActionUtils actionUtils = new ActionUtils();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);

		prepaymentspage.clickAddicon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name2);
		prepaymentspage.enterDescription(description2);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.clickOnAddProductButton();
		prepaymentspage.clickAddicon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method3"));
		prepaymentspage.select_PrepaymentModel(jsonFileUtils.getJsonValue("Prepayment model"));
		prepaymentspage.enter_Spread(jsonFileUtils.getJsonValue("Spread_value"));
		prepaymentspage.click_Apply();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name2);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name2), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Copy Prepayment Rule
	 * 
	 * @throws Exception
	 */

	//@Test(enabled = true, priority = 8, groups = "prePayments")
	public void copy() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);

		prepaymentspage.SearchwithName(name2);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name2), String.format("No Results Found"));
		prepaymentspage.click_search_Result_Checkbox();
		prepaymentspage.click_Copy_Icon();
		prepaymentspage.switch_Copy_frame();
		prepaymentspage.enter_Copied_Name(copiedName);
		prepaymentspage.enter_Copied_descripion(description2 + "_Copied");
		prepaymentspage.click_Copy_yes();
		driver.switchTo().parentFrame();
		prepaymentspage.SearchwithName(copiedName);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(copiedName), "Results Not Found");
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create New Prepayments Rule with Arctangent
	 * 
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 9, groups = "prePayments")
	public void addArctangent() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		ActionUtils actionUtils = new ActionUtils();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);

		prepaymentspage.clickAddicon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name3);
		prepaymentspage.enterDescription(description3);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.clickOnAddProductButton();
		// prepaymentspage.clickAddicon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method4"));
		prepaymentspage.enter_Constant_Coe_1(jsonFileUtils.getJsonValue("Constant Coe.K 1"));
		prepaymentspage.enter_Constant_Coe_2(jsonFileUtils.getJsonValue("Constant Coe.K 2"));
		prepaymentspage.enter_Constant_Coe_3(jsonFileUtils.getJsonValue("Constant Coe.K 3"));
		prepaymentspage.enter_Constant_Coe_4(jsonFileUtils.getJsonValue("Constant Coe.K 4"));
		prepaymentspage.enter_Spread(jsonFileUtils.getJsonValue("Spread_value"));
		prepaymentspage.click_Apply();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name3);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name3), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Delete Prepayment Rule
	 * 
	 * @param method
	 * @throws Exception
	 */

	//@Test(enabled = true, priority = 10,  groups = "prePayments")
	public void delete() throws Exception {
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.SearchwithName(name3);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name3), String.format("No Results Found"));
		prepaymentspage.click_search_Result_Checkbox();
		prepaymentspage.click_Delete();
		prepaymentspage.switch_deleteframe();
		prepaymentspage.click_Delete_Yes();
		driver.switchTo().parentFrame();
		prepaymentspage.SearchwithName(name3);
		prepaymentspage.clicksearchicon();
		softAssert.assertEquals("No Results Found", prepaymentspage.getText_No_Result_Found(),
				String.format("Result Matched"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();

	}

	/**
	 * Create New Prepayments Rule with PSA
	 * 
	 * @param method
	 * @throws Exception
	 */
	// @Test(enabled = true, priority = 11, groups = "prePayments")
	public void addPSA() throws Exception {
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		System.out.println("Window swithed");
		prepaymentspage.enterName(name4);
		prepaymentspage.enterDescription(description4);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.click_AssumptionList();
		prepaymentspage.select_Dimension_Member_Name(jsonFileUtils.getJsonValue("Dimension_Name_dropdown"));
		prepaymentspage.Enter_Dimension_Member_ProdName(jsonFileUtils.getJsonValue("Product_Name"));
		prepaymentspage.select_Dimension_Member_status(jsonFileUtils.getJsonValue("Dimension_Member_Status"));
		prepaymentspage.click_Search_Member();
		prepaymentspage.click_Assumption_list_Result();
		prepaymentspage.click_Add_Prod_Assumptionlist();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method5"));
		prepaymentspage.click_Apply();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name4);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name4), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create New Prepayments Rule with Adcoprepayment
	 * 
	 * @param method
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 12, groups = "prePayments")
	public void addAdcoPrepayment() throws Exception {
	
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		System.out.println("Window swithed");
		prepaymentspage.enterName(name5);
		prepaymentspage.enterDescription(description5);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.click_AssumptionList();
		prepaymentspage.select_Dimension_Member_Name(jsonFileUtils.getJsonValue("Dimension_Name_dropdown"));
		prepaymentspage.Enter_Dimension_Member_ProdName(jsonFileUtils.getJsonValue("Product_Name"));
		prepaymentspage.select_Dimension_Member_status(jsonFileUtils.getJsonValue("Dimension_Member_Status"));
		prepaymentspage.click_Search_Member();
		prepaymentspage.click_Assumption_list_Result();
		prepaymentspage.click_Add_Prod_Assumptionlist();
		ActionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method6"));
		prepaymentspage.click_Apply();
		ActionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		ActionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name5);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name5), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();

	}

	/**
	 * Verify Assumption list with DimensionName
	 * 
	 * @param method
	 * @throws Exception
	 */

	// @Test(enabled = true, priority = 13,  groups = "prePayments")
	public void AssumptionListDimensionName() throws Exception {
	
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		System.out.println("Window swithed");
		prepaymentspage.enterName(name12);
		prepaymentspage.enterDescription(description12);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.click_AssumptionList();
		prepaymentspage.select_Dimension_Member_Name(jsonFileUtils.getJsonValue("Dimension_Name_dropdown"));
		prepaymentspage.Enter_Dimension_Member_ProdName(jsonFileUtils.getJsonValue("Product_Name"));
		prepaymentspage.select_Dimension_Member_status(jsonFileUtils.getJsonValue("Dimension_Member_Status"));
		prepaymentspage.click_Search_Member();
		softAssert.assertEquals(jsonFileUtils.getJsonValue("Product_Name"), prepaymentspage.getText_SearchedMember(),
				String.format("Member not found"));
		prepaymentspage.click_Cancel_Button();
		prepaymentspage.switch_Cancel_Frame();
		prepaymentspage.click_Cancel_Yes();
		actionUtils.switchWindowUsingCount(driver);
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Verify Assumption list with NumericCode
	 * 
	 * @param method
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 14,groups = "prePayments")
	public void AssumptionListNumericcode() throws Exception {
	
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		ActionUtils actionUtils = new ActionUtils();
		
		
		prepaymentspage.clickAddicon();
	    actionUtils.switchWindowUsingCount(driver);
		System.out.println("Window swithed");
		prepaymentspage.enterName(name13);
		prepaymentspage.enterDescription(description13);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.click_AssumptionList();
		prepaymentspage.select_Dimension_Member_Numericcode(
				jsonFileUtils.getJsonValue("select_Dimension_Member_Numericcode_status"));
		prepaymentspage
				.enter_Dimension_Member_ProdNumericcode(jsonFileUtils.getJsonValue("Dimension_Member_Numeric_Code"));
		prepaymentspage.select_Dimension_Member_status(jsonFileUtils.getJsonValue("Dimension_Member_Status"));
		prepaymentspage.click_Search_Member();
		softAssert.assertEquals(jsonFileUtils.getJsonValue("Product_Name"), prepaymentspage.getText_SearchedMember(),
				String.format("Member not found"));
		prepaymentspage.click_Cancel_Button();
		prepaymentspage.switch_Cancel_Frame();
		prepaymentspage.click_Cancel_Yes();
		actionUtils.switchWindowUsingCount(driver);
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Verify Assumption list with AlphaNumericCode
	 * 
	 * @param method
	 * @throws Exception
	 */
	 //@Test(enabled = true, priority = 15,groups = "prePayments")
	public void AssumptionListAlphaNumericcode() throws Exception {
	
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		System.out.println("Window swithed");
		prepaymentspage.enterName(name14);
		prepaymentspage.enterDescription(description14);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.click_AssumptionList();
		prepaymentspage.select_Dimension_Member_Alphanumeric_Code(
				jsonFileUtils.getJsonValue("select_Dimension_Member_alphaNumericcode_status"));
		prepaymentspage.enter_Dimension_Member_Alphanumeric_memberCode(
				jsonFileUtils.getJsonValue("Dimension_Member_AlphaNumeric_Code"));
		prepaymentspage.select_Dimension_Member_status(jsonFileUtils.getJsonValue("Dimension_Member_Status"));
		prepaymentspage.click_Search_Member();
		softAssert.assertEquals(jsonFileUtils.getJsonValue("Product_Name"), prepaymentspage.getText_SearchedMember(),
				String.format("Member not found"));
		prepaymentspage.click_Cancel_Button();
		prepaymentspage.switch_Cancel_Frame();
		prepaymentspage.click_Cancel_Yes();
		actionUtils.switchWindowUsingCount(driver);
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Cancel a created Prepayment Rule
	 * 
	 * @param method
	 * @throws Exception
	 */

	// @Test(enabled = true, priority = 16, groups = "prePayments")
	public void cancelPrepayment() throws Exception {
	
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		final String name = "Auto_" + new ActionUtils().randomNumber();
		final String description = name + "_desc";
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		System.out.println("Window swithed");
		prepaymentspage.enterName(name6);
		prepaymentspage.enterDescription(description6);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.clickOnAddProductButton();
		prepaymentspage.clickAddicon();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method1"));
		prepaymentspage.click_Cancel_Prepayment();
		prepaymentspage.switch_Cancel_Frame();
		prepaymentspage.click_Cancel_Yes();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Cancel_Button();
		prepaymentspage.switch_Cancel_Frame();
		prepaymentspage.click_Cancel_Yes();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name6);
		prepaymentspage.clicksearchicon();
		softAssert.assertEquals("No Results Found", prepaymentspage.getText_No_Result_Found(),
				String.format("Result Matched"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();

	}

	/**
	 * Create Prepayment with Conditional Assumption with Donotcalculate
	 * 
	 * @param method
	 * @throws Exception
	 */

	// @Test(enabled = true, priority = 17, groups = "prePayments")
	public void conditionalAssumptionDoNotCalculate() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name7);
		prepaymentspage.enterDescription(description7);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.click_Conditional_Assumption();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switch_to_Filter_Frame();
		prepaymentspage.select_Filter(jsonFileUtils.getJsonValue("Filter"));
		prepaymentspage.click_Add_Condition();
		prepaymentspage.select_Method(jsonFileUtils.getJsonValue("Cal_Method1"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Apply_cal_Method();
		driver.switchTo().defaultContent();
		prepaymentspage.switch_to_Filter_Frame();
		System.out.println(prepaymentspage.getText_Changes_Applied());
		softAssert.assertEquals("Yes", prepaymentspage.getText_Changes_Applied(), String.format("Changes not Applied"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Save_CalMethod();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name7);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name7), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Search for create Preapayment Rule
	 * 
	 * @param method
	 */

	 //@Test(enabled = true, priority = 18,groups = "prePayments" )
	public void searchName() {
		
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.SearchwithName(name7);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name7),
				String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create Prepayment with Conditional Assumption with Constant
	 * 
	 * @param method
	 * @throws Exception
	 */

	 //@Test(enabled = true, priority = 19, groups = "prePayments")
	public void conditionalAssumptionConstant() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
	
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name8);
		prepaymentspage.enterDescription(description8);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.click_Conditional_Assumption();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switch_to_Filter_Frame();
		prepaymentspage.select_Filter(jsonFileUtils.getJsonValue("Filter"));
		prepaymentspage.click_Add_Condition();
		prepaymentspage.select_Method(jsonFileUtils.getJsonValue("Cal_Method2"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_calMethod_Frame();
		prepaymentspage.enter_Percent(jsonFileUtils.getJsonValue("Constant_Percent"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Apply_cal_Method();
		driver.switchTo().defaultContent();
		prepaymentspage.switch_to_Filter_Frame();
		System.out.println(prepaymentspage.getText_Changes_Applied());
		softAssert.assertEquals("Yes", prepaymentspage.getText_Changes_Applied(), String.format("Changes not Applied"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Save_CalMethod();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name8);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name8), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Search for created Rule with Name and Dimension
	 * 
	 * @param method
	 * @throws Exception
	 */

	//@Test(enabled = true, priority = 20,  groups = "prePayments")
	public void searchNameDimen() throws Exception {
		
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		SoftAssert softAssert = new SoftAssert();
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.SearchwithName(name8);
		prepaymentspage.SelectDimension(jsonFileUtils.getJsonValue("Dimension"));
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name8),
				String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create Prepayment with Conditional Assumption with Prepaymentmodel
	 * 
	 * @param method
	 * @throws Exception
	 */
	 //@Test(enabled = true, priority = 21, groups = "prePayments")
	public void conditionalAssumptionPrepaymentModel() throws Exception {
	
		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
	
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name9);
		prepaymentspage.enterDescription(description9);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.click_Conditional_Assumption();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switch_to_Filter_Frame();
		prepaymentspage.select_Filter(jsonFileUtils.getJsonValue("Filter"));
		prepaymentspage.click_Add_Condition();
		prepaymentspage.select_Method(jsonFileUtils.getJsonValue("Cal_Method3"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_calMethod_Frame();
		prepaymentspage.select_PrepaymentModel(jsonFileUtils.getJsonValue("Prepayment model"));
		prepaymentspage.enter_Spread(jsonFileUtils.getJsonValue("Spread_value"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Apply_cal_Method();
		driver.switchTo().defaultContent();
		prepaymentspage.switch_to_Filter_Frame();
		System.out.println(prepaymentspage.getText_Changes_Applied());
		softAssert.assertEquals("Yes", prepaymentspage.getText_Changes_Applied(), String.format("Changes not Applied"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Save_CalMethod();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name9);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name9), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create Prepayment with Conditional Assumption with Arctangent
	 * 
	 * @param method
	 * @throws Exception
	 */

	// @Test(enabled = true, priority = 22, groups = "prePayments")
	public void conditionalAssumptionArctangent() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name10);
		prepaymentspage.enterDescription(description10);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.click_Conditional_Assumption();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switch_to_Filter_Frame();
		prepaymentspage.select_Filter(jsonFileUtils.getJsonValue("Filter"));
		prepaymentspage.click_Add_Condition();
		prepaymentspage.select_Method(jsonFileUtils.getJsonValue("Cal_Method4"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_calMethod_Frame();
		prepaymentspage.select_CalMethod(jsonFileUtils.getJsonValue("Cal_Method4"));
		prepaymentspage.enter_Constant_Coe_1(jsonFileUtils.getJsonValue("Constant Coe.K 1"));
		prepaymentspage.enter_Constant_Coe_2(jsonFileUtils.getJsonValue("Constant Coe.K 2"));
		prepaymentspage.enter_Constant_Coe_3(jsonFileUtils.getJsonValue("Constant Coe.K 3"));
		prepaymentspage.enter_Constant_Coe_4(jsonFileUtils.getJsonValue("Constant Coe.K 4"));
		prepaymentspage.enter_Spread(jsonFileUtils.getJsonValue("Spread_value"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Apply_cal_Method();
		driver.switchTo().defaultContent();
		prepaymentspage.switch_to_Filter_Frame();
		System.out.println(prepaymentspage.getText_Changes_Applied());
		softAssert.assertEquals("Yes", prepaymentspage.getText_Changes_Applied(), String.format("Changes not Applied"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Save_CalMethod();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name10);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name10), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create Prepayment with Conditional Assumption with PSA
	 * 
	 * @param method
	 * @throws Exception
	 */
	//@Test(enabled = true, priority = 23, groups = "prePayments")
	public void conditionalAssumptionPSA() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name11);
		prepaymentspage.enterDescription(description11);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.click_Conditional_Assumption();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switch_to_Filter_Frame();
		prepaymentspage.select_Filter(jsonFileUtils.getJsonValue("Filter"));
		prepaymentspage.click_Add_Condition();
		prepaymentspage.select_Method(jsonFileUtils.getJsonValue("Cal_Method5"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Apply_cal_Method();
		driver.switchTo().defaultContent();
		prepaymentspage.switch_to_Filter_Frame();
		System.out.println(prepaymentspage.getText_Changes_Applied());
		softAssert.assertEquals("Yes", prepaymentspage.getText_Changes_Applied(), String.format("Changes not Applied"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Save_CalMethod();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name11);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name11), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	/**
	 * Create Prepayment with Conditional Assumption with AdcoPrepayment
	 * 
	 * @param method
	 * @throws Exception
	 */

	//@Test(enabled = true, priority = 24, groups = "prePayments")
	public void conditionalAssumptionAdcoPayment() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		JSONFileUtils jsonFileUtils = new JSONFileUtils(className);
		PrepaymentsPage prepaymentspage = new PrepaymentsPage(logger);
		
		prepaymentspage.clickAddicon();
		ActionUtils actionUtils = new ActionUtils();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.enterName(name12);
		prepaymentspage.enterDescription(description12);
		prepaymentspage.selectProd_hier(jsonFileUtils.getJsonValue("Product_Hierarchy"));
		prepaymentspage.verifyProductAndExpand(jsonFileUtils.getJsonValue("Product"));
		prepaymentspage.verifySubProductAndCheck(jsonFileUtils.getJsonValue("Subproduct"));
		prepaymentspage.click_Conditional_Assumption();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switch_to_Filter_Frame();
		prepaymentspage.select_Filter(jsonFileUtils.getJsonValue("Filter"));
		prepaymentspage.click_Add_Condition();
		prepaymentspage.select_Method(jsonFileUtils.getJsonValue("Cal_Method6"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		Thread.sleep(3000);
		prepaymentspage.click_Apply_cal_Method();
		driver.switchTo().defaultContent();
		prepaymentspage.switch_to_Filter_Frame();
		System.out.println(prepaymentspage.getText_Changes_Applied());
		softAssert.assertEquals("Yes", prepaymentspage.getText_Changes_Applied(), String.format("Changes not Applied"));
		driver.switchTo().defaultContent();
		prepaymentspage.switch_apply_frame();
		prepaymentspage.click_Save_CalMethod();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.click_Save();
		actionUtils.switchWindowUsingCount(driver);
		prepaymentspage.switchFrameByID(prepaymentspage.mainIframeID);
		prepaymentspage.SearchwithName(name12);
		prepaymentspage.clicksearchicon();
		softAssert.assertTrue(prepaymentspage.verfiySearchedText(name12), String.format("No Results Found"));
		driver.switchTo().defaultContent();
		
		softAssert.assertAll();

	}
}
