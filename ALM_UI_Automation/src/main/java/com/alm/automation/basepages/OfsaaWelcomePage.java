package com.alm.automation.basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alm.automation.actionutils.ActionUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnvironmentVariables;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.alm.automation.globalvariables.EnumDeclarations.WindowTitles;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class OfsaaWelcomePage extends BaseSuite {
	ExtentTest logger;

	public OfsaaWelcomePage(ExtentTest logger) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.logger = logger;
	}

	@FindBy(xpath = "//*[@id='appContent']/div[1]/div/div[1]")
	private static WebElement Navigate_to_ALM;
	@FindBy(xpath = "//span[@class='oj-navigationlist-item-label' and text()='Asset Liability Management']")
	private static WebElement ALM_Navigation_List;
	@FindBy(xpath = "//span[text()='Global Preferences']")
	private static WebElement GlobalPreferences_Navigation;
	@FindBy(xpath = "//span[text()='Application Preferences']")
	private static WebElement ApplicationPreferences_Navigation;
	@FindBy(xpath = "//span[text()='ALM Maintenance']")
	private static WebElement ALMMaintenance_Navigation;
	@FindBy(xpath = "(//div[contains(@class,'oj-navigationlist-group-item oj-navigationlist-item oj-default')])[18]")
	private static WebElement ALMAssumptionSpecification_Navigation;
	@FindBy(xpath = "//span[text()='ALM Processing']")
	private static WebElement ALMprocessing_Navigation;
	@FindBy(xpath = "//span[text()='Log Out']")
	private static WebElement logOutButton;
	@FindBy(xpath="//div[contains(@class,'oj-flex-bar-start')]//button[contains(@class,'oj-button-lg')]")
	private static WebElement appNavigation;
	@FindBy(xpath="//div[contains(@class,'oj-navigationlist-group-item')]")
	private static WebElement homeIcon;
	
	
	public void clickAppNavigation()
	{
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver,appNavigation , "app_Navigation", logger);
	}
	
	public void clickHomeIcon()
	{
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver,homeIcon, "home_icon", logger);
	}
	
	public void clickonNavigate_to_ALM() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, Navigate_to_ALM, "Asset Liability Management Button", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void clickonNavigate_to_ALMList() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, ALM_Navigation_List, "Asset Liability Management Navigation", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void clickonNavigate_to_GlobalPreferences() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, GlobalPreferences_Navigation, "GlobalPreferences Navigation", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void clickonNavigate_to_ApplicationPreferences() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, ApplicationPreferences_Navigation, "ApplicationPreferences Navigation",
				logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void clickonNavigate_to_ALMMaintenance() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, ALMMaintenance_Navigation, "ALMMaintenance Navigation", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void clickonNavigate_to_ALMAssumptionSpecification() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, ALMAssumptionSpecification_Navigation,
				"ALMAssumptionSpecification Navigation", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	public void clickonNavigate_to_ALMprocessing() {
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, ALMprocessing_Navigation, "ALMprocessing Navigation", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	// public void clickOnMRMMOption() {
	// SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	// ActionUtils.switchWindowUsingTitle(driver,WindowTitles.WELCOMEPAGETITLE.getValue(),
	// logger);
	// BaseSuite.waitForPageLoaded();
	// SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	// ActionUtils.clickOnElement(driver,market_Risk_Measurement_and_Management_Option,"MRMM
	// Option Button", logger);
	// SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	// }

	public void closeAlert() {
		ActionUtils.dismissAlert(driver, logger);
	}

	public void closeTheAplication() {
		ActionUtils.closeTheApplication(driver, logger);
	}

	public void logOutApllication() {
		WebElement userLogOutButton = driver
				.findElement(By.xpath("//div[contains(@class,'oj-button-label')]//span[text()='"
						+ EnvironmentVariables.USER_NAME.toUpperCase() + "']"));
		ActionUtils.clickOnElement(driver, userLogOutButton, "User LogOut button", logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, logOutButton, "LogOut Button", logger);
		logger.log(Status.INFO, "Application got LogOut Successfully !!!");
	}

	// public void clickOnNavigationMRMMOption() {
	// SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
	// ActionUtils.clickOnElement(driver,navigationListMRMMOption,"Navigation
	// option", logger);
	// }
	//
	// public MRMMPage clickOnMRMMListMRMM() {
	// SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
	// ActionUtils.clickOnElement(driver,mRMMListMRMMOption,"MRMM List MRMM Option",
	// logger);
	// return new MRMMPage(logger);
}
