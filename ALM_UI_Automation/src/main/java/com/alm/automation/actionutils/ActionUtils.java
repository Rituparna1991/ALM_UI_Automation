package com.alm.automation.actionutils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alm.automation.genericutils.SleepUtils;
import com.alm.automation.globalvariables.EnumDeclarations.SleepPeriod;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * Common util methods
 * 
 * @author : Ritu
 *
 */

public class ActionUtils {

	private static ExtentTest logger;

	private static WebDriver driver;

	/**
	 * 
	 * @param driver
	 * @param frameID
	 * @param logger
	 */
	public static void switchToFrameByID(WebDriver driver, String frameID, ExtentTest logger) {
		driver.switchTo().frame(frameID);
		logger.log(Status.INFO, "IFrame " + frameID + " switch has been selected successfully !!!");
	}

	/**
	 * 
	 * @param element
	 */
	public static void switchtoFrame(WebElement element)// changed
	{
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
		driver.switchTo().frame(element);

	}

	/**
	 * 
	 * @param driver
	 * @param className
	 * @return
	 */
	public static String getScreenShot(WebDriver driver, String className) {
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "/ScreenShots/" + className + "/";
		String destinationFile = destPath + SleepUtils.currentTimeInMilliseconds() + ".png";
		try {
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
			FileUtils.copyFile(sourceFile, new File(destinationFile));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return destinationFile;
	}

	public static void switchWindowUsingCount(WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		String[] handleArray = handles.toArray(new String[handles.size()]);
		driver.switchTo().window(handleArray[handles.size() - 1]);
		// SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
	}

	/**
	 * 
	 * @param driver
	 * @param windowTitle
	 * @param logger
	 */

	public static void switchWindowUsingTitle(WebDriver driver, String windowTitle, ExtentTest logger) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equalsIgnoreCase(windowTitle)) {
				logger.log(Status.INFO, "Window got Switched successfully !!! Current window title is : "
						+ driver.switchTo().window(window).getTitle() + "");
				driver.switchTo().window(window);
			}
		}
	}

	/**
	 * 
	 * @param locator
	 * @param text
	 * @throws Exception
	 */
	public static void SelectDropdownValue(WebElement locator, String text) throws Exception {
		try {
			SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
			Select select = new Select((locator));
			SleepUtils.sleep(SleepPeriod.SMALLSLEEP.getValue());
			select.selectByVisibleText(text);
			logger.log(Status.INFO, " " + text + "has been selected successfully !!!");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * @param driver
	 * @param logger
	 * @return Capture the current window title
	 */
	public static String getPageTitle(WebDriver driver, ExtentTest logger) {
		logger.log(Status.INFO, " Captured window title is : " + driver.getTitle() + "");
		return driver.getTitle();
	}

	public static void clickOnElement(WebDriver driver, WebElement element, String elementName, ExtentTest logger) {
		if (element.isDisplayed()) {
			SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
			element.click();
			logger.log(Status.INFO, " " + elementName + " has been clicked successfully !!!");
		} else if (waitForElementVisible(driver, element)) {
			element.click();
			logger.log(Status.INFO, "" + elementName + " has been clicked successfully !!!");
		} else {
			element.click();
			logger.log(Status.FAIL, " " + elementName + " has been failed to click on the element !!!");
		}
	}

	public static WebElement waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, SleepPeriod.EXPLICTSHORTWAITINSECONDS.getValue());
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, SleepPeriod.EXPLICTSHORTWAITINSECONDS.getValue());
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, SleepPeriod.SHORTSLEEP.getValue());
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void switchToalert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, SleepPeriod.SHORTSLEEP.getValue());
		driver.switchTo().alert();
	}

	/**
	 * 
	 * Dismiss the Java pop up or Alerts
	 * 
	 * @param driver
	 * @param logger
	 */
	public static void dismissAlert(WebDriver driver, ExtentTest logger) {
		Alert alert;
		try {
			String popUpMessage = driver.switchTo().alert().getText();
			if (popUpMessage != null) {
				logger.log(Status.INFO, "Java Pop up Identified & captured messege is : " + popUpMessage + "");
				alert = driver.switchTo().alert();
				alert.dismiss();
				logger.log(Status.INFO, "Dismissed the Java pop");
			}
		} catch (NoAlertPresentException e) {
		}
	}

	public static void closeTheApplication(WebDriver driver, ExtentTest logger) {
		if (driver != null) {
			driver.close();
			logger.log(Status.INFO, "Closed the Application Successfully !!!!");
		}
	}

	public static void enterText(WebElement element, String text, ExtentTest logger) {
		if (element.isDisplayed()) {
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
			element.sendKeys(text);
			logger.log(Status.INFO, "" + text + " : text entered successfully !!!");
		} else {
			element.sendKeys(text);
			logger.log(Status.FAIL, "Failed to enter the text : " + text + " !!!");
		}
	}

	public static void clearText(WebElement element, ExtentTest logger) {
		if (element.isDisplayed()) {
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
			element.clear();
			logger.log(Status.INFO, "Existing text cleared successfully !!!");
		} else {
			element.clear();
			logger.log(Status.FAIL, "Failed to clear the text  !!!");
		}
	}

	public static void clickOnElementUsingJavaScript(WebDriver driver, WebElement element, ExtentTest logger) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
		logger.log(Status.INFO, "Element clicked using Java Script successfully !!!");
	}

	public static boolean radioButtonStatus(WebElement element, String radioButton, ExtentTest logger) {
		boolean status = false;
		if (element.isDisplayed()) {
			status = element.isSelected();
			logger.log(Status.INFO, "" + radioButton + "  status is " + status + " !!!");
		}
		return status;
	}

	public static String getAttribute(WebElement element, String attributeName, ExtentTest logger) {
		String attributeValue = null;
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		attributeValue = element.getAttribute(attributeName);
		logger.log(Status.INFO, "Captuerd Attribute Values is :" + attributeValue + "  !!!");
		return attributeValue;
	}

	public static String getAttributeUsingJavaScript(WebDriver driver, String element, String attribueName,
			ExtentTest logger) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object value = javascriptExecutor.executeScript("document.getAttribute(" + attribueName + ");", element);
		logger.log(Status.INFO, "Element clicked using Java Script successfully !!!");
		return value.toString();
	}

	public static String getText(WebElement element, ExtentTest logger) {
		String errorMessage = null;
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
		if (element.isDisplayed()) {
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
			errorMessage = element.getText();
			logger.log(Status.INFO, "Captured  Messages is : " + errorMessage + " !!!");
		}
		return errorMessage;
	}

	public static boolean elementNotVisiable(WebElement element, ExtentTest logger) {
		boolean status = false;
		try {
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
			element.isDisplayed();
			status = false;
		} catch (Exception e) {
			status = true;
		}
		return status;
	}

	public static boolean elementVisiable(WebElement element, ExtentTest logger) {
		boolean status = false;
		try {
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
			element.isDisplayed();
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public static boolean getRadioButtonStatus(WebElement element, String radioButtonName, ExtentTest logger) {
		boolean status = false;
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
		try {
			if (element.isEnabled()) {
				SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
				status = element.isEnabled();
				logger.log(Status.INFO, " " + radioButtonName + " Radio button status is : " + status + " !!!");
			}
		} catch (Exception e) {
			logger.log(Status.INFO, "Radio button status is : " + status + " !!!");
		}
		return status;
	}

	public static void enableRadioButton(WebElement element, String radioButtonName, ExtentTest logger) {
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
		SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
		element.isEnabled();
		logger.log(Status.INFO, "" + radioButtonName + " Enabled Radio button successfully !!!");
	}

	public static String getText(WebElement element, String elementName, ExtentTest logger) {
		String errorMessage = null;
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
		if (element.isDisplayed()) {
			SleepUtils.sleep(SleepPeriod.SHORTSLEEP.getValue());
			errorMessage = element.getText();
			logger.log(Status.INFO, "Captured Error Messages is : " + errorMessage + " !!!");
		}
		return errorMessage;
	}

	public static int getListOfElementCount(List<WebElement> element, String elementName, ExtentTest logger) {
		int count = 0;
		SleepUtils.sleep(SleepPeriod.NORMALSLEEP.getValue());
		count = element.size();
		logger.log(Status.INFO, " " + elementName + " count is  : " + count + " !!!");
		return count;
	}

	public static void scrollDownForDropDown(WebDriver driver, WebElement element, ExtentTest logger) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
		logger.log(Status.INFO, " Scrolling the DropDown  !!!");
	}

	/**
	 * 
	 * @return
	 */
	public int randomNumber() {
		Random rand = new Random();
		int value = rand.nextInt(5000);
		return value;

	}

}
