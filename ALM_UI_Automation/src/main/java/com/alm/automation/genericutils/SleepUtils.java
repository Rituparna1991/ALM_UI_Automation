package com.alm.automation.genericutils;

public class SleepUtils {
	
	public static void sleep(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static long currentTimeInMilliseconds() {
		return System.currentTimeMillis();
	}
	
	public static String getCurrentDirPath() {
		return System.getProperty("user.dir");
	}

	public static String uniqueValue() {
		String value=Long.toString(currentTimeInMilliseconds());
		return value.substring(6, 13);
	}
	
	public static void main(String[] args) {
		System.out.println(uniqueValue());
	}

}
