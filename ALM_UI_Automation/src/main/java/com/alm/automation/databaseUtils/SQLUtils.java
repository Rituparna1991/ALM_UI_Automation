package com.alm.automation.databaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLUtils {
	private static Connection connection = null;
	private static Statement statement = null;

	public static void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void executeQuery() {
		// getConnection();
		ResultSet resultSet = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.40.137.154:1522:MRMMQA18C", "ofsaaatmsat244",
					"password123");
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select CHILD_ID from dim_mkt_risk_pos_hier where CREATED_BY = 'SYSADMN'");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return resultSet;
	}

	public static void main(String[] args) {
		executeQuery();
	}

}
