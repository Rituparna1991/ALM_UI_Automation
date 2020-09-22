package com.alm.automation.basepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alm.automation.actionutils.ActionUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.aventstack.extentreports.ExtentTest;

public class LibraryPage extends BaseSuite {
	ExtentTest logger;

	public LibraryPage(ExtentTest logger) {
		PageFactory.initElements(driver, this);
		this.logger=logger;
	}
	
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Portfolio']") private static WebElement mrmmPortfolioOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Risk Factor']") private static WebElement mrmmRiskFactorOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='RFET']") private static WebElement mrmmRFETOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Stress Scenario']") private static WebElement mrmmStressScenarioOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Pricing Policy']") private static WebElement mrmmPricingPolicyOption;
	@FindBy(xpath="//span[contains(@class,'oj-navigationlist-item') and text()='Bucket Definition']") private static WebElement mrmmBucketDefinitionOption;

	public PortfolioPage selectPortfolioOption() {
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
		ActionUtils.clickOnElement(driver,mrmmPortfolioOption,"Portfolio Option", logger);
		return new PortfolioPage(logger);
	}
	
	
}
