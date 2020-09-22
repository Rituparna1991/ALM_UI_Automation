package com.alm.automation.genericutils;

import com.alm.automation.basepages.BaseSuite;
import com.alm.automation.globalvariables.GlobalVariable;

public class GeneralUtils {

	public static void killChromeProcess() {
		if (BaseSuite.properties.getProperty("env.browser").equalsIgnoreCase(GlobalVariable.CHROMEBROWSERNAME)) {
			String command = "taskkill /F /IM " + GlobalVariable.CHROMEDRIVEREXE + " /T";
			System.out.println(command);
			try {
				Runtime.getRuntime().exec(command);
			} catch (Exception exception) {

			}
		} else if (BaseSuite.properties.getProperty("env.browser").equalsIgnoreCase(GlobalVariable.CHROMEBROWSERNAME)) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM " + GlobalVariable.CHROMEDRIVEREXE + "/T");
			} catch (Exception exception) {

			}
		}
	}

}
