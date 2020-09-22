package com.alm.automation.basepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alm.automation.actionutils.ActionUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.alm.automation.globalvariables.EnumDeclarations.WindowTitles;
import com.aventstack.extentreports.ExtentTest;

public class MRMMPage extends BaseSuite {
	ExtentTest logger;

	public MRMMPage(ExtentTest logger) {
		PageFactory.initElements(driver, this);
		this.logger=logger;
	}

	@FindBy(xpath="//div[@class='oj-flex-bar-start']//span") private static WebElement mrmmNavigationList;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Home']") private static WebElement mrmmHomeOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Library']//ancestor::li//a") private static WebElement mrmmLibraryOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Instrument Valuation']") private static WebElement mrmmInstrumentValuationOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Historical Simulation']") private static WebElement mrmmHistoricalSimulationOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Model Validation']") private static WebElement mrmmModelValidationOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Default Configurations']") private static WebElement mrmmDefaultConfigurationsOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Dimension and Hierarchy Configuration']") private static WebElement mrmmDimensionandHierarchyConfigurationOption;

	public void clickOnMRMMOptionButton() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.switchWindowUsingTitle(driver, WindowTitles.MRMMPAGETITLE.getValue(), logger);
		ActionUtils.getPageTitle(driver, logger);
		ActionUtils.clickOnElement(driver,mrmmNavigationList,"MRMM Option Button",logger);
	}
	
	
	public LibraryPage clickOnMRMMLibraryListButton() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver,mrmmLibraryOption,"MRMM Library List", logger);
		return new LibraryPage(logger);
	}
	
	

}
