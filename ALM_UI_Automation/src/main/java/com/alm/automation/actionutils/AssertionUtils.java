package com.alm.automation.actionutils;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AssertionUtils {
	
	public static void assertString(String actual,String expected,ExtentTest logger) {
		if(actual.trim().equalsIgnoreCase(expected.trim())) {
		Assert.assertEquals(actual, expected,"Actual value & Expected values are Matching !!!!");
		}else {
			Assert.assertEquals(actual, expected,"Actual value & Expected values are Not Matching !!!!");
			logger.log(Status.FAIL, "Actual value is "+actual+" & Expected values is "+expected+",  Not Matching");
		}
	}
	
	public static void assertBoolean(boolean actual,ExtentTest logger) {
		if(actual) {
		Assert.assertTrue(actual,"Element Status is "+actual+" !!!!");
		logger.log(Status.PASS, " Element status is "+actual+"");
		}else {
			Assert.assertTrue(actual," Element status is : "+actual+" !!!!");
			logger.log(Status.FAIL, " Element status is "+actual+"");
		}
	}
	public static void assertInteger(int actual,int expected,ExtentTest logger) {
		if(actual == expected) {
		Assert.assertEquals(actual, expected,"Actual value & Expected values are Matching !!!!");
		logger.log(Status.PASS, "Actual value is "+actual+" & Expected values is "+expected+",  Not Matching");
		}else {
			Assert.assertEquals(actual, expected,"Actual value & Expected values are Not Matching !!!!");
			logger.log(Status.FAIL, "Actual value is "+actual+" & Expected values is "+expected+",  Not Matching");
		}
	}
	
	
	public static void assertFalseBoolean(boolean actual,ExtentTest logger) {
		if(!actual) {
		Assert.assertFalse(actual,"Element Status is "+actual+" !!!!");
		logger.log(Status.PASS, "Element Status is "+actual+"");
		}else {
			Assert.assertFalse(actual,"Element status is : "+actual+" !!!!");
			logger.log(Status.FAIL, " Element status is "+actual+"");
		}
	}
	
	public static void assertNotNull(String actual,ExtentTest logger) {
		if(actual != null) {
		Assert.assertNotNull(actual,"Capture Value is "+actual+" !!!!");
		logger.log(Status.PASS, "Capture Value is  "+actual+"");
		}else {
			Assert.assertNotNull(actual,"Capture Value is : "+actual+" !!!!");
			logger.log(Status.FAIL, "Capture Value is : "+actual+"");
		}
	}

}
