package com.alm.automation.basepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alm.automation.actionutils.ActionUtils;
import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.alm.automation.globalvariables.EnumDeclarations.WindowTitles;
import com.aventstack.extentreports.ExtentTest;

public class OfsaaLoginPage extends BaseSuite {
	ExtentTest logger = null;

	public OfsaaLoginPage(ExtentTest logger) {
		PageFactory.initElements(driver, this);
		this.logger = logger;
	}

	/**
	 * Locators definitions
	 */
	@FindBy(xpath = "//input[@name='vUsrID']")
	private static WebElement ofsaaUserName;
	@FindBy(xpath = "//input[@name='vActualPassword']")
	private static WebElement ofsaaPassword;
	@FindBy(xpath = "//a[text()='Login']")
	private static WebElement ofsaaLoginButton;

	public OfsaaWelcomePage ofsaaLogin(String userName, String passWord) {
		ActionUtils.switchWindowUsingTitle(driver, WindowTitles.LOGINPAGETITLE.getValue(), logger);
		ActionUtils.enterText(ofsaaUserName, userName, logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.enterText(ofsaaPassword, passWord, logger);
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		ActionUtils.clickOnElement(driver, ofsaaLoginButton, "Login Button", logger);
		return new OfsaaWelcomePage(logger);
	}

	public String getPageTitle() {
		SleepUtils.sleep(2000);
		return ActionUtils.getPageTitle(driver, logger);
	}

}
