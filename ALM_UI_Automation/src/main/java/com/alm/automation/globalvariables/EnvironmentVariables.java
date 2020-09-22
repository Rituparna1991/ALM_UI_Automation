package com.alm.automation.globalvariables;

import com.alm.automation.basepages.BaseSuite;

public class EnvironmentVariables extends BaseSuite {

	public static final String APPLICATION_URL = properties.getProperty("env.url");
	public static final String BROWSER = properties.getProperty("env.browser");
	public static final String USER_NAME = properties.getProperty("env.username");
	public static final String PASSWORD = properties.getProperty("env.password");
	public static final String DATABASEIP = properties.getProperty("env.databaseip");
	public static final String DATABASEPORT = properties.getProperty("env.databaseport");
	public static final String DATABASESCHEMA = properties.getProperty("env.databaseschema");
	public static final String DATABASECONFIGUSERNAME = properties.getProperty("env.databaseconfigusername");
	public static final String DATABASECONFIGPASSWORD = properties.getProperty("env.databaseconfigpassword");
	public static final String DATABASEATOMICUSERNAME = properties.getProperty("env.databaseatomicusername");
	public static final String DATABASEATOMICPASSWORD = properties.getProperty("env.databaseatomicpassword");
	public static final String DATABASEDRIVERPATH = properties.getProperty("env.databasedriver");

}
