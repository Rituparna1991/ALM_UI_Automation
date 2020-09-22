package com.alm.automation.basepages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alm.automation.actionutils.ActionUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnumDeclarations.InstrumentType;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class PortfolioPage extends BaseSuite {
	ExtentTest logger;

	public PortfolioPage(ExtentTest logger) {
		PageFactory.initElements(driver, this);
		this.logger=logger;
	}

	@FindBy(xpath="//span[@class='fa fa-plus fa-lg oj-button-icon oj-start']") private static WebElement addNewButton;
	@FindBy(xpath="//input[contains(@value,'POSITIO')]") private static WebElement portflioTypePositionRadioButton;
	@FindBy(xpath="//input[contains(@value,'DIMENSION')]") public static WebElement portflioTypeDimentionRadioButton;
	@FindBy(xpath="//input[contains(@value,'TRADING')]") private static WebElement portflioTypeTradingDeskRadioButton;
	@FindBy(xpath="//input[contains(@id,'portfolioName|inp')]") private static WebElement portfolioNameTextBox;
	@FindBy(xpath="//span[@class='oj-inputtext-clear-icon']") private static WebElement portfolioNameTextBoxClearText;
	@FindBy(xpath="//textarea[contains(@id,'Desc')]") private static WebElement portfolioDescriptionTextBox;
	@FindBy(xpath="//div[contains(text(),'Format is incorrect.')]//parent::span//child::span") private static WebElement formatIncorrectMessageError;
	@FindBy(xpath="//div[contains(text(),'There are too many ')]//parent::span//child::span") private static WebElement charLengthError;
	@FindBy(xpath="//div[contains(text(),'Value is ')]//parent::span//child::span") private static WebElement enterSomeTextErrorMessage;
	@FindBy(xpath="//div[contains(text(),'There are ')]//parent::span//child::span") public static WebElement emptyErrorMessage;
	@FindBy(xpath="//span[contains(text(),'Invalid Descripti')]") public static WebElement invalidDescritionErrorMessage;
	@FindBy(xpath="//span[contains(text(),'Description cannot exceed 30')]") public static WebElement maximumCharDescriptionError;
	@FindBy(id="Read|rb") public static WebElement accessTypeReadRadioButton;
	@FindBy(id="ReadWrite|rb") public static WebElement accessTypeReadWriteRadioButton;
	@FindBy(id="portfolioVersion|input")private static WebElement versionText;
	@FindBy(xpath="//span[contains(@id,'ojChoiceId_folder')]") private static WebElement folderMRMMValue;
	@FindBy(id="saveButton") public static WebElement saveButton;
	@FindBy(id="submitButton") public static WebElement submitButton;
	@FindBy(id="approvePortfolioButton") public static WebElement approvePortfolioButton;
	@FindBy(id="rejectPortfolioButton") public static WebElement rejectPortfolioButton;
	@FindBy(xpath="//a[text()='Home']") public static WebElement navigationBreadCrumbsHome;
	@FindBy(xpath="//a[text()='Portfolio Summary']") public static WebElement navigationBreadCrumbsPortfolioSummary;
	@FindBy(xpath="//li[text()='New']") public static WebElement navigationBreadCrumbsNew;
	@FindBy(id="availablevalues") public static WebElement availableHierarchies;
	@FindBy(id="selectedvalues") public static WebElement selectedValuesHierarchies;
	@FindBy(xpath="//span[contains(text(),'Add')]//parent::*//child::span[1]") public static WebElement portfolioPositionAddButton;
	@FindBy(xpath="//span[contains(text(),'Filter')]//parent::*//child::span[1]") public static WebElement portfolioPositionFilterButton;
	@FindBy(xpath="//h4[text()='Available Position Filters']") public static WebElement portfolioAvailablePositionFilterHeaders;
	@FindBy(xpath="//span[contains(text(),'Apply')]//parent::div") public static WebElement portfolioPositionFilterApplyButton;
	@FindBy(xpath="//span[contains(text(),'Reset')]//parent::div") public static WebElement portfolioPositionFilterResetButton;
	@FindBy(xpath="//p[contains(text(),'Instrument')]") public static WebElement portfolioPositionFilterInstrumentType;
	@FindBy(xpath="//p[contains(text(),'Entity')]") public static WebElement portfolioPositionFilterEntityName;
	@FindBy(xpath="//p[contains(text(),'Counter')]") public static WebElement portfolioPositionFilterCounterPartyName;
	@FindBy(xpath="//p[contains(text(),'Currency')]//child::a") public static WebElement portfolioPositionFilterCurrency;
	@FindBy(xpath="//p[contains(text(),'Instrument')]//ancestor::oj-collapsible//div//following-sibling::span") public static List<WebElement> portfolioPositionFilterInstrumentTypeListCount;
	@FindBy(xpath="//p[contains(text(),'Entity')]//ancestor::oj-collapsible//div//following-sibling::span") public static List<WebElement> portfolioPositionFilterEntityNameListCount;
	@FindBy(xpath="//p[contains(text(),'Counter')]//ancestor::oj-collapsible//div//following-sibling::span") public static List<WebElement> portfolioPositionFilterCounterPartyNameListCount;
	@FindBy(xpath="//p[contains(text(),'Currency')]//ancestor::oj-collapsible//div//following-sibling::span") public static List<WebElement> portfolioPositionFilterCurrencyListCount;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//tbody//tr[1]//td[2]//input") public static WebElement firstAvailablePostionsCheckBox;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//tbody//tr[1]//td[3]") public static WebElement firstAvailablePostionsAccountNumber;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//tbody//tr[1]//td[4]") public static WebElement firstAvailablePostionsInstrumentCode;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//tbody//tr[1]//td[6]") public static WebElement firstAvailablePostionsInstrumentType;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//tbody//tr[1]//td[9]") public static WebElement firstAvailablePostionsCurrencyCode;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//tbody//tr[2]//td[2]//input") public static WebElement secondAvailablePostionsCheckBox;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//tbody//tr[3]//td[2]//input") public static WebElement thirdAvailablePostionsCheckBox;
	@FindBy(id="availablePositionMessageDiv") public static WebElement AvailablePositionBeforeFilter;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[1]//td[3]") public static WebElement firstSelectedPostionsAccountNumber;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[1]//td[4]") public static WebElement firstSelectedPostionsInstrumentCode;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[1]//td[6]") public static WebElement firstSelectedPostionsInstrumentType;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[1]//td[9]") public static WebElement firstSelectedPostionsCurrencyCode;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[1]//td[2]//input") public static WebElement firstSelectedPostionsCheckBox;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[2]//td[2]//input") public static WebElement secondSelectedPostionsCheckBox;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[3]//td[2]//input") public static WebElement thirdSelectedPostionsCheckBox;
	@FindBy(xpath="//span[text()='Remove']//parent::div") public static WebElement selectedPostionsRemoveButton;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[2]//td[3]") public static WebElement secondSelectedPostionsAccountNumber;
	@FindBy(xpath="//table[contains(@aria-label,'Selected')]//tbody//tr[2]//td[3]") public static WebElement thirdSelectedPostionsAccountNumber;
	@FindBy(xpath="//table[contains(@aria-label,'Available')]//ancestor::div[@data-bind='ojModule: router.moduleConfig']//div[contains(@id,'available-position-p')]//oj-input-number//input") public static WebElement availablePageSizeTextBox;
	
	
	
	
	
	
	
	
	
	public void clickOnPlusButton() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, addNewButton, "Portfolio Add Button", logger);
	}

	public boolean verifyPositionRadioButton() {
		return ActionUtils.radioButtonStatus(portflioTypePositionRadioButton, "Portfolio Position Radio Button", logger);
	}

	public void clickOnPositionRadioButton() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, portflioTypePositionRadioButton, "Portfolio Position Radio Button", logger);
	}

	public void clickOnDimentionRadioButton() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, portflioTypeDimentionRadioButton, "Portfolio Dimention Radio Button", logger);
	}

	public void clickOnTradingDeskRadioButton() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, portflioTypeTradingDeskRadioButton, "Portfolio Trading Desk Radio Button", logger);
	}


	public boolean verifyPositionRadioButtonStatus() {
		boolean status=false;
		String attributeValue=null;
		attributeValue=ActionUtils.getAttribute(portflioTypePositionRadioButton, "class", logger);
		if(attributeValue.trim().contains("oj-selected")) {
			status = attributeValue.contains("oj-selected");
			logger.log(Status.INFO, "Position Type Radio Button status is : "+status+"");
		}else {
			status = attributeValue.contains("oj-selected");
			logger.log(Status.FAIL, "Position Type Radio Button status is : "+status+"");
		}
		return status;
	}

	public void enterPortfolioName(String enterValidPortfoliName) {
		boolean status=false;
		String attributeValue=null;
		ActionUtils.enterText(portfolioNameTextBox, enterValidPortfoliName, logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		/*attributeValue=ActionUtils.getAttribute(portfolioNameTextBox, "aria-invalid", logger);
		if(attributeValue.equalsIgnoreCase("false")) {
			status=true;
		}else {
			status=false;
		}
		return status;*/
	}

	public String getFormatIncorrectErrorMessageText() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		return ActionUtils.getText(formatIncorrectMessageError, logger);
	}

	public String getCharectorLengthErrorMessageText() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		return ActionUtils.getText(charLengthError, logger);
	}


	public void clickOnDescriptionTextBox() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, portfolioDescriptionTextBox, "Description box", logger);
	}

	public void clickOnNameTextBox() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, portfolioNameTextBox, "Name box", logger);
	}

	public void clickOnNameTextBoxClearText() {
		SleepUtils.sleep(SleepPeriod.LONGSLEEP.getValue());
		ActionUtils.clickOnElement(driver, portfolioNameTextBoxClearText, "Name text box Clear text Icon", logger);
	}

	public boolean validateEmptyErrorMessage(WebElement element) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		return ActionUtils.elementNotVisiable(element, logger);
	}

	public String getEnterSomeTextErrorMessageText() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		return ActionUtils.getText(enterSomeTextErrorMessage, logger);
	}

	public String getEmptyErrorMessageText() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		return ActionUtils.getText(emptyErrorMessage, logger);
	}


	public void enterPortfolioDescription(String enterPortfolioDescription) {
		ActionUtils.enterText(portfolioDescriptionTextBox,enterPortfolioDescription, logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void clearPortfolioDescription() {
		ActionUtils.clearText(portfolioDescriptionTextBox, logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public String inValidDescriptionErrorMessage(WebElement element) {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		return ActionUtils.getText(element, logger);
	}

	public boolean getRadioButtonStatus(WebElement radioButton,String attributeValue) {
		String text=null;
		boolean status  =false;
		text=ActionUtils.getAttribute(radioButton, attributeValue, logger);
		if(text.trim().contains("oj-selected")) {
			status=true;
		}else {
			status=false;
		}
		return status;
	}
	
	public String getAttributeValue(WebElement radioButton,String attributeValue) {
		String text=null;
		text=ActionUtils.getAttribute(radioButton, attributeValue, logger);
		return text;
	}

	public void clickOnAccessTypeRadioButton(WebElement element,String buttonName) {
		ActionUtils.clickOnElement(driver,element, buttonName, logger);
	}

	public String getVersionText() {
		return ActionUtils.getAttribute(folderMRMMValue,"value", logger);
	}

	public String getFolderPackageText() {
		return ActionUtils.getText(folderMRMMValue, logger);
	}

	public boolean verifyButton(WebElement element) {
		return ActionUtils.elementVisiable(element, logger);
	}

	public void clickOnSaveButton() {
		ActionUtils.clickOnElement(driver, saveButton, "Portfolio Save Button", logger);
	}

	public void clickOnPositionPortfolioFilterButton() {
		ActionUtils.clickOnElement(driver, portfolioPositionFilterButton, "Portfolio Filter Button", logger);
	}

	public void clickOnPositionPortfolioAddButton() {
		ActionUtils.clickOnElement(driver, portfolioPositionAddButton, "Portfolio Position Portfolio Add Button", logger);
	}

	public String getText(WebElement element) {
		return ActionUtils.getText(element, logger);
	}

	public int getListOfElementCount(List<WebElement> element,String elementName) {
		return ActionUtils.getListOfElementCount(element, elementName, logger);
	}

	public void selectInstrumentType(String filterName,String instrumentName) {
		WebElement element=null;
		if(filterName.contains("Instrument")) {
			element =driver.findElement(By.xpath("//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}else if(filterName.contains("Entity")) {
			element =driver.findElement(By.xpath("//p[text()='Entity Name']//parent::oj-collapsible//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}else if(filterName.contains("Counterparty")) {
			element =driver.findElement(By.xpath("//p[text()='Counterparty Name']//parent::oj-collapsible//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}else if(filterName.contains("Currency")) {
			element =driver.findElement(By.xpath("//p[text()='Currency']//parent::oj-collapsible//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}
		logger.log(Status.INFO, "Constrcuted Xpath is : "+element+"");
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.scrollDownForDropDown(driver,element,logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, element, "Instrument Type", logger);
	}

	public void clickOnInstrumentType() {
		ActionUtils.clickOnElement(driver, portfolioPositionFilterInstrumentType, "Instrument Type", logger);
	}

	public void clickOnEntityName() {
		ActionUtils.clickOnElement(driver, portfolioPositionFilterEntityName, "Entity Name", logger);
	}

	public void clickOnCounterPartyName() {
		ActionUtils.clickOnElement(driver, portfolioPositionFilterCounterPartyName, "ConuterParty Name", logger);
	}

	public void clickOnCurrency() {
		ActionUtils.clickOnElement(driver, portfolioPositionFilterCurrency, "Currency", logger);
	}

	public boolean verifyAppliedFilterStatus(String filterName,String instrumentName) {
		WebElement element=null;
		String attributeValue=null;
		boolean status=false;
		if(filterName.contains("Instrument")) {
			element =driver.findElement(By.xpath("//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}else if(filterName.contains("Entity")) {
			element =driver.findElement(By.xpath("//p[text()='Entity Name']//parent::oj-collapsible//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}else if(filterName.contains("Counterparty")) {
			element =driver.findElement(By.xpath("//p[text()='Counterparty Name']//parent::oj-collapsible//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}else if(filterName.contains("Currency")) {
			element =driver.findElement(By.xpath("//p[text()='Currency']//parent::oj-collapsible//oj-option[text()='"+instrumentName+"']//ancestor::span//input"));
		}
		logger.log(Status.INFO, "Constrcuted Xpath is : "+element+"");
		ActionUtils.scrollDownForDropDown(driver,element,logger);
		attributeValue=ActionUtils.getAttribute(element, "class", logger);
		if(attributeValue.trim().contains("oj-selected")) {
			status=true;
		}else {
			status=false;
		}
		return status;
	}

	public void clickOnFilterResetButton() {
		ActionUtils.clickOnElement(driver, portfolioPositionFilterResetButton, "Filter Reset", logger);
	}

	public void clickOnFilterApplyButton() {
		ActionUtils.clickOnElement(driver, portfolioPositionFilterApplyButton, "Filter Apply", logger);
	}

	public ArrayList<String> getAvailablePositionsFirstRowRecords() {
		ArrayList<String> value= new ArrayList<String>();
		value.add(ActionUtils.getText(firstAvailablePostionsAccountNumber, logger));
		value.add(ActionUtils.getText(firstAvailablePostionsInstrumentCode, logger));
		value.add(ActionUtils.getText(firstAvailablePostionsInstrumentType, logger));
		value.add(ActionUtils.getText(firstAvailablePostionsCurrencyCode, logger));
		return value;
	}

	public ArrayList<String> verfiyAvailablePositionsColumnValues() {
		WebElement element;
		ArrayList<String> value= new ArrayList<String>();
		for(int i=2;i<=8 ; i++) {
			element = driver.findElement(By.xpath("//table[contains(@aria-label,'Available')]//th["+i+"]//div[2]//child::div[1]"));
			logger.log(Status.INFO, "Constrcuted Xpath is : "+element+"");
			value.add(ActionUtils.getText(element, logger));
		}
		return value;
	}
	
	public ArrayList<String> verfiySelectedPositionsColumnValues() {
		WebElement element;
		ArrayList<String> value= new ArrayList<String>();
		for(int i=2;i<=8 ; i++) {
			element = driver.findElement(By.xpath("//table[contains(@aria-label,'Selected')]//th["+i+"]//div[2]//child::div[1]"));
			logger.log(Status.INFO, "Constrcuted Xpath is : "+element+"");
			value.add(ActionUtils.getText(element, logger));
		}
		return value;
	}

	public void clickOnAvailablePositionCheckBox() {
		SleepUtils.sleep(4000);
		ActionUtils.clickOnElementUsingJavaScript(driver, firstAvailablePostionsCheckBox, logger);
	}
	
	public ArrayList<String> getSelectedPositionsFirstRowRecords() {
		ArrayList<String> value= new ArrayList<String>();
		value.add(ActionUtils.getText(firstSelectedPostionsAccountNumber, logger));
		value.add(ActionUtils.getText(firstSelectedPostionsInstrumentCode, logger));
		value.add(ActionUtils.getText(firstSelectedPostionsInstrumentType, logger));
		value.add(ActionUtils.getText(firstSelectedPostionsCurrencyCode, logger));
		return value;
	}
	
	public void clickOnAvailablePositionsHeader() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, portfolioAvailablePositionFilterHeaders, "Avaialble Position Filter Header", logger);
	}
	
	public void clickOnAvailablePositionsAddButton() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElementUsingJavaScript(driver, portfolioPositionAddButton,  logger);
	}

	public void clickOnAvailablePositionCheckBox(WebElement element) {
		SleepUtils.sleep(4000);
		ActionUtils.clickOnElementUsingJavaScript(driver, element, logger);
	}
	
	public ArrayList<String> getSelectedPositionsAccountName() {
		ArrayList<String> value= new ArrayList<String>();
		value.add(ActionUtils.getText(firstSelectedPostionsAccountNumber, logger));
		value.add(ActionUtils.getText(secondSelectedPostionsAccountNumber, logger));
		value.add(ActionUtils.getText(thirdSelectedPostionsAccountNumber, logger));
		return value;
	}

	public void clickOnSelectionPositionCheckBox(WebElement element) {
		SleepUtils.sleep(4000);
		ActionUtils.clickOnElementUsingJavaScript(driver, element, logger);
	}
	
	public void clickOnRemoveButton() {
		ActionUtils.clickOnElementUsingJavaScript(driver, selectedPostionsRemoveButton, logger);
	}
	
	public ArrayList<Boolean> getSelectedPositionsAccountNameStatus() {
		ArrayList<Boolean> value= new ArrayList<Boolean>();
		value.add(ActionUtils.elementNotVisiable(firstSelectedPostionsAccountNumber, logger));
		value.add(ActionUtils.elementNotVisiable(secondSelectedPostionsAccountNumber, logger));
		value.add(ActionUtils.elementNotVisiable(thirdSelectedPostionsAccountNumber, logger));
		return value;
	}


}
