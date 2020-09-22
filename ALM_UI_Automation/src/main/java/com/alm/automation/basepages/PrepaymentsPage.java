package com.alm.automation.basepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alm.automation.actionutils.ActionUtils;
import com.alm.automation.genericutils.JSONFileUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.aventstack.extentreports.ExtentTest;

/**
 * Page class for prePayments
 * 
 * @author rhota
 *
 */
public class PrepaymentsPage extends BaseSuite {
	private static ExtentTest logger;
	private String className = null;
	JSONFileUtils jsonFileUtils = new JSONFileUtils(className);

	public PrepaymentsPage(ExtentTest logger) {
		PageFactory.initElements(driver, this);
		PrepaymentsPage.logger = logger;
	}

	@FindBy(xpath = "//span[text()='Prepayments']")
	private static WebElement Prepayments;
	@FindBy(xpath = "//select[@id='FSI_M_OBJECT_DEFINITION_B.LEAF_NUM_ID']")
	private static WebElement Dimension;
	@FindBy(xpath = "//div[@id='globalBody']")
	private static WebElement GlobalBody;
	@FindBy(xpath = "//div[@id='aai_offcanvas_close']")
	private static WebElement NavigationtoRightPanel;
	public static String mainIframeID = "7_aai_main_fr";
	@FindBy(xpath = "//a/img[contains(@title,'Add')]")
	public static WebElement Addicon;
	@FindBy(xpath = "//input[@id='FSI_M_OBJECT_DEFINITION_TL.SHORT_DESC']")
	private static WebElement SearchName;
	@FindBy(xpath = "//td[contains(@class,'curvlettable1')]//td[contains(@id,'enableSearch')]/a/img")
	private static WebElement searchicon;
	@FindBy(xpath = "//input[@name='prepmtName']")
	private static WebElement Name;
	@FindBy(xpath = "//td[contains(@class,'rowCell')]/span")
	private static List<WebElement> SearchResult;
	@FindBy(xpath = "//textarea[@id='desTxt']")
	private static WebElement Description;
	@FindBy(xpath = "//td/select[@id='pdtHierarchy']")
	private static WebElement Prod_hier;
	@FindBy(xpath = "(//a[contains(@class,'oj-component-icon oj-clickable-icon-nocontext oj-rowexpander-expand-icon')])[1]")//(//td[contains(@class,'ygtvtp')])[1]--8074
	private static WebElement Total_Products_Expand;
	@FindBy(xpath = "//td[contains(@class,'oj-table-data-cell-a')]")//td[contains(@class,'ygtvcontent')]
	private static List<WebElement> Total_Products;
	@FindBy(xpath = "//span[text()='Toatl_Asset']]")
	WebElement Total_Asset;
	@FindBy(xpath = "//div[contains(@id,'enableButtonsAssumpBrowser')]//td[@id='addnew']")
	private static WebElement Add_Product_Definition;
	@FindBy(xpath = "//select[@name='ppmtCalculationMethod']")
	private static WebElement Calculation_Method;
	@FindBy(xpath = "//a[text()='Apply ']")
	private static WebElement Apply_Button;
	@FindBy(xpath = "//tr[@onClick='saveClicked()']")
	private static WebElement Save_Button;
	@FindBy(xpath = "//a[text()='Assumption List']")
	private static WebElement Assumption_List;
	@FindBy(xpath = "//select[@id='codeCriteria']")
	private static WebElement Dimension_Member_Numericcode;
	@FindBy(xpath = "//select[@id='nameCriteria']")
	private static WebElement Dimension_Member_Name;
	@FindBy(xpath = "//select[@id='dimStatus']")
	private static WebElement Dimension_Member_status;
	@FindBy(xpath = "//input[@id='dimName']")
	private static WebElement Dimension_Member_ProdName;
	@FindBy(xpath = "//img[contains(@src,'/ofsa3/images/gridtoolbar_search.gif')]")
	private static WebElement Search_Member;
	@FindBy(xpath = "//td[@class='rowCell']/div[contains(@id,'productName')]")
	private static WebElement Member_Search_result;
	@FindBy(xpath = "//input[@id='dimCode']")
	private static WebElement Dimension_Member_ProdNumericcode;
	@FindBy(xpath = "//select[@id='alphaNumericCodeCriteria']")
	private static WebElement Dimension_Member_Alphanumeric_Code;
	@FindBy(xpath = "//input[@id='dimAlphaNumericCodeTxt']")
	private static WebElement Dimension_Member_Alphanumeric_memberCode;
	@FindBy(xpath = "//tr[@onclick='cancelBrowser()']")
	private static WebElement Cancel_Button;
	@FindBy(xpath = "//iframe[contains(@src,'/ofsa3/fsapps/common_oj/index.jsp?root=error')]")
	private static WebElement Cancel_Popup;
	@FindBy(xpath = "//span[text()='Yes']")
	private static WebElement Cancel_yes;
	@FindBy(xpath = "//input[@name='checkBoxDefinition']")
	private static WebElement Search_Result_checkbox;
	@FindBy(xpath = "//img[@title='Delete']")
	private static WebElement Delete_icon;
	@FindBy(xpath = "//div[contains(@id,'showModalDialogDiv')]/iframe")
	private static WebElement Delete_Frame;
	@FindBy(xpath = "(//div[contains(@id,'delconfrButton')]//td[2])[1]")
	private static WebElement Delete_yes;
	@FindBy(xpath = "//input[@id='percentC1']")
	private static WebElement Constant_Percent;
	@FindBy(xpath = "//select[@id='selectModelCustom1']")
	private static WebElement Select_PrepaymentModel;
	@FindBy(xpath = "//input[@id='spreadTxt']")
	private static WebElement Spread;
	@FindBy(xpath = "//input[@id='K11']")
	private static WebElement Constant_Coe_1;
	@FindBy(xpath = "//input[@id='K21']")
	private static WebElement Constant_Coe_2;
	@FindBy(xpath = "//input[@id='K31']")
	private static WebElement Constant_Coe_3;
	@FindBy(xpath = "//input[@id='K41']")
	private static WebElement Constant_Coe_4;
	@FindBy(xpath = "//input[@id='chk_0']")
	private static WebElement Assumption_list_Result;
	@FindBy(xpath = "//a[@onclick='newRule()']//img[@id='add_newSearchTab']")
	private static WebElement Add_Prod_Assumptionlist;
	@FindBy(xpath = "//img[contains(@title,'Conditional Assumption')]")
	private static WebElement Conditional_Assumption;
	@FindBy(xpath = "//select[contains(@id,'filterSelect')]")
	private static WebElement Filter;
	@FindBy(xpath = "//a[@id='genCondButtonHref']/img[@title='Add Condition']")
	private static WebElement Add_Condition;
	private String filter_frame = "header";
	@FindBy(xpath = "//select[@id='methodSelect0']")
	private static WebElement Method;
	private String apply_frame = "buttonContainer";
	@FindBy(xpath = "//a[text()='Apply']")
	private static WebElement Apply_cal_Method;
	@FindBy(xpath = "//label[contains(@class,'calabel')]")
	private static WebElement Changes_Applied;
	@FindBy(xpath = "//a[text()='Save']")
	private static WebElement Save;
	@FindBy(xpath = "//span[text()='No Results Found']")
	private static WebElement No_Result_Found;
	@FindBy(xpath = "//td[@class='buttonCenter']/a[text()='Cancel ']")
	private static WebElement Cancel_Prepayment;
	@FindBy(xpath = "//div[@id='showModalDialogDiv']/iframe")
	private static WebElement Cancel_Frame;
	@FindBy(xpath = "//span[text()='Yes']")
	private static WebElement Cancel_Yes;
	@FindBy(xpath = "//img[@title='Edit']")
	public static WebElement Edit_icon;
	@FindBy(xpath = "//div[contains(@id,'productMethod')]")
	private static WebElement Defined_Method;
	@FindBy(xpath = "//img[contains(@src,'../images/gridtoolbar_view')]")
	public static WebElement Veiw_Icon;
	@FindBy(xpath = "//img[@src='../images/gridtoolbar_saveas.gif']")
	private static WebElement Copy_Icon;
	@FindBy(xpath = "//iframe[contains(@src,'2FprepaymentSaveAsORCopy')]")
	private static WebElement Copy_frame;
	@FindBy(xpath = "//span[text()='Save']")
	private static WebElement Copy_yes;
	@FindBy(xpath = "//input[@name='strName']")
	private static WebElement Copied_Name;
	@FindBy(xpath = "//textarea[@name='strDesc']")
	private static WebElement Copied_descripion;
	private String calMethod_Frame = "main";
	@FindBy(xpath = "//div[contains(@class,'oj-flex-bar-start')]//button[contains(@class,'oj-button-lg')]")
	public static WebElement appNavigation;
	@FindBy(xpath="//tr[@onclick='window.close()']")
	public static WebElement close;
	
	
	public void clickClose()
	{
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, close, "close", logger);
	}

	public void switch_calMethod_Frame() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		driver.switchTo().frame(calMethod_Frame);
	}

	public void enter_Copied_descripion(String copiedDesc) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(Copied_descripion, copiedDesc, logger);
	}

	public void enter_Copied_Name(String copiedName) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(Copied_Name, copiedName, logger);
	}

	public void click_Copy_yes() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Copy_yes, "copy_yes", logger);
	}

	public void switch_Copy_frame() {

		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		driver.switchTo().frame(Copy_frame);
	}

	public void click_Copy_Icon() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Copy_Icon, "copy", logger);
	}

	public String getAttribute_DescriptionField() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String namefield = ActionUtils.getText(Description, logger);
		return namefield.trim();
	}

	public String getText_DescriptionField() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String namefield = ActionUtils.getText(Description, logger);
		return namefield.trim();
	}

	public String getText_NameField() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String namefield = ActionUtils.getText(Name, logger);
		return namefield.trim();
	}

	public String getAttribute_NameField() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String attributeValue = ActionUtils.getAttribute(Name, "disabled", logger);
		return attributeValue.trim();
	}

	public void click_Veiw_Icon() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Veiw_Icon, "view", logger);
	}

	public String getText_Defined_Method() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String definedMethod = ActionUtils.getText(Defined_Method, logger);
		return definedMethod.trim();
	}

	public void clear_name() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clearText(Name, logger);
	}

	public void clear_description() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clearText(Description, logger);
	}

	public void click_Edit_icon() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Edit_icon, "edit", logger);
	}

	public void click_Cancel_Yes() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Cancel_Yes, "cancel", logger);
	}

	public void switch_Cancel_Frame() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		driver.switchTo().frame(Cancel_Frame);
	}

	public void click_Cancel_Prepayment() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Cancel_Prepayment, "cancel", logger);
	}

	public String getText_No_Result_Found() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String noResult = ActionUtils.getText(No_Result_Found, "Result", logger);
		return noResult;
	}

	public void click_Save_CalMethod() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Save, "Save", logger);

	}

	public String getText_Changes_Applied() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String status = ActionUtils.getText(Changes_Applied, logger);
		return status.trim();
	}

	public void click_Apply_cal_Method() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Apply_cal_Method, "calMethodApply", logger);
	}

	public void switch_apply_frame() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		driver.switchTo().frame(apply_frame);
	}

	public void select_Method(String method) throws Exception {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.SelectDropdownValue(Method, method);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void switch_to_Filter_Frame() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		driver.switchTo().frame(filter_frame);

	}

	public void click_Add_Condition() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Add_Condition, "addcondition", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void select_Filter(String filter) throws Exception {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.SelectDropdownValue(Filter, filter);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void click_Conditional_Assumption() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Conditional_Assumption, "ConditionalAssumption", logger);
	}

	public void click_Add_Prod_Assumptionlist() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Add_Prod_Assumptionlist, "add", logger);
	}

	public void click_Assumption_list_Result() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Assumption_list_Result, "result", logger);
	}

	public void enter_Constant_Coe_1(String constant_Coe_1) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Constant_Coe_1.sendKeys(Keys.CONTROL, Keys.chord("a"));
		Constant_Coe_1.sendKeys(Keys.BACK_SPACE);
		Constant_Coe_1.sendKeys(constant_Coe_1);
	}

	public void enter_Constant_Coe_2(String constant_Coe_2) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Constant_Coe_2.sendKeys(Keys.CONTROL, Keys.chord("a"));
		Constant_Coe_2.sendKeys(Keys.BACK_SPACE);
		Constant_Coe_2.sendKeys(constant_Coe_2);
	}

	public void enter_Constant_Coe_3(String constant_Coe_3) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Constant_Coe_3.sendKeys(Keys.CONTROL, Keys.chord("a"));
		Constant_Coe_3.sendKeys(Keys.BACK_SPACE);
		Constant_Coe_3.sendKeys(constant_Coe_3);
	}

	public void enter_Constant_Coe_4(String constant_Coe_4) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Constant_Coe_4.sendKeys(Keys.CONTROL, Keys.chord("a"));
		Constant_Coe_4.sendKeys(Keys.BACK_SPACE);
		Constant_Coe_4.sendKeys(constant_Coe_4);
	}

	public void enter_Spread(String spreadvalue) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Spread.sendKeys(Keys.CONTROL, Keys.chord("a"));
		Spread.sendKeys(Keys.BACK_SPACE);
		Spread.sendKeys(spreadvalue);
	}

	public void select_PrepaymentModel(String prepaymodel) throws Exception {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.SelectDropdownValue(Select_PrepaymentModel, prepaymodel);

	}

	public void clear_Percent() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Constant_Percent.clear();
	}

	public void enter_Percent(String percent) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Constant_Percent.sendKeys(Keys.CONTROL, Keys.chord("a"));
		Constant_Percent.sendKeys(Keys.BACK_SPACE);
		Constant_Percent.sendKeys(percent);
	}

	public void switch_deleteframe() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		driver.switchTo().frame(Delete_Frame);
	}

	public void click_Delete_Yes() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Delete_yes, "delete_yes", logger);
	}

	public void click_Delete() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Delete_icon, "delete", logger);
	}

	public void click_search_Result_Checkbox() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Search_Result_checkbox, "checkbox", logger);
	}

	public void click_Cancel_yes() {
		ActionUtils.clickOnElement(driver, Cancel_yes, "cancel", logger);
	}

	public void switch_Popup() {
		ActionUtils.switchtoFrame(Cancel_Popup);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public String getName() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String name = Name.getText();
		return name;
	}

	public void clickOnPrepayments() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Prepayments, "Prepayments_Navigation", logger);
	}

	public void SelectDimension(String value) throws Exception {

		ActionUtils.SelectDropdownValue(Dimension, value);
		SleepUtils.sleep(SleepPeriod.LONGSLEEP.getValue());
	}

	public boolean GlobalbodyisDisplayed() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		boolean status = ActionUtils.elementVisiable(GlobalBody, logger);
		return status;
	}

	public void clickNavigationtoRightPanel() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, NavigationtoRightPanel, "Navigation_RightPanel", logger);

	}

	public void switchFrameByID(String frameID) {
		ActionUtils.switchToFrameByID(driver, frameID, logger);
	}

	public void clickAddicon() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Addicon, "Addnew", logger);
	}

	public void SearchwithName(String name) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(SearchName, name, logger);

	}

	public void clicksearchicon() {

		ActionUtils.clickOnElement(driver, searchicon, "Search", logger);
		SleepUtils.sleep(SleepPeriod.LONGSLEEP.getValue());

	}

	public void enterName(String name) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(Name, name, logger);
	}

	public boolean verfiySearchedText(String SearchedText) {
		boolean flag = false;
		for (WebElement result : SearchResult) {
			if (result.getText().equalsIgnoreCase(SearchedText)) {
				flag = true;
				break;
			}
		}
		return flag;

	}

	public void enterDescription(String desc) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(Description, desc, logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void selectProd_hier(String prod_hier_value) throws Exception {

		ActionUtils.SelectDropdownValue(Prod_hier, prod_hier_value);
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
	}

	public boolean totalasset_displayed() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		Boolean status = ActionUtils.elementVisiable(Total_Asset, logger);
		return status;
	}

	public void verifyProductAndExpand(String product) {
System.out.println("============="+Total_Products.size());
		for (int i = 1; i <= Total_Products.size(); i++) {
			WebElement products = driver
					.findElement(By.xpath("(//span[contains(@class,'ygtvlabellf')])[" + i + "]"));
			System.out.println("================="+products.getText());
			if (products.getText().equalsIgnoreCase(product)) {
				SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
				Total_Products_Expand.click();
				logger.info("Expanded the products");
				break;
			} else {
				logger.info("'%s' product does not found" + product);
			}
		}
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void verifySubProductAndCheck(String subProduct) {
		for (int j = 2; j <= Total_Products.size(); j++) {
			WebElement subProducts = driver
					.findElement(By.xpath("(//span[contains(@class,'ygtvlabellf')])[" + j + "]"));
			WebElement productCheckBox = driver
					.findElement(By.xpath("(//td[contains(@class,'oj-table-data-cell oj-form-control-inherit oj-table-vgrid-lines')]/input)[" + j + "]"));
			if (subProducts.getText().equalsIgnoreCase(subProduct)) {
				SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
				productCheckBox.click();
				logger.info("Checked the checkbox");
				break;
			} else {
				logger.info("'%s' sub product does not found" + subProduct);
			}
		}

	}

	public void clickOnAddProductButton() {
		if (Add_Product_Definition.isEnabled() == true) {
			
			ActionUtils.clickOnElement(driver, Add_Product_Definition, "AddProdDef", logger);
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		}
	}

	public void select_CalMethod(String cal_method_value) throws Exception {
		ActionUtils.SelectDropdownValue(Calculation_Method, cal_method_value);
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());

	}

	public void click_Apply() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Apply_Button, "Apply_Button", logger);
	}

	public void click_Save() {

		ActionUtils.clickOnElement(driver, Save_Button, "Save", logger);
	}

	public void click_AssumptionList() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Assumption_List, "assumptionlist", logger);
	}

	public void select_Dimension_Member_Name(String dimension_name) throws Exception {
		ActionUtils.SelectDropdownValue(Dimension_Member_Name, dimension_name);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());

	}

	public void select_Dimension_Member_status(String dimension_member_status) throws Exception {
		ActionUtils.SelectDropdownValue(Dimension_Member_status, dimension_member_status);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());

	}

	public void Enter_Dimension_Member_ProdName(String membername) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(Dimension_Member_ProdName, membername, logger);

	}

	public void click_Search_Member() {

		ActionUtils.clickOnElement(driver, Search_Member, "searchmember", logger);
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
	}

	public String getText_SearchedMember() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		String membername = ActionUtils.getText(Member_Search_result, logger);
		return membername;
	}

	public void select_Dimension_Member_Numericcode(String dimensionnumericcode_status) throws Exception {
		ActionUtils.SelectDropdownValue(Dimension_Member_Numericcode, dimensionnumericcode_status);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void enter_Dimension_Member_ProdNumericcode(String membernumericcode) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(Dimension_Member_ProdNumericcode, membernumericcode, logger);
	}

	public void select_Dimension_Member_Alphanumeric_Code(String dimensionmemberdropdown) throws Exception {
		ActionUtils.SelectDropdownValue(Dimension_Member_Alphanumeric_Code, dimensionmemberdropdown);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void enter_Dimension_Member_Alphanumeric_memberCode(String memberalphanumericcode) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(Dimension_Member_Alphanumeric_memberCode, memberalphanumericcode, logger);
	}

	public void click_Cancel_Button() {
		ActionUtils.clickOnElement(driver, Cancel_Button, "cancel", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

}
