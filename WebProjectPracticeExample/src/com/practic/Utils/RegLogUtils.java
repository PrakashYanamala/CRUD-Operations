package com.practic.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

import com.practice.Constants.RegLogConstants;

public class RegLogUtils {

	
	public Connection createconnection() {
		Connection con =null;
		
		try {
			Class.forName(RegLogConstants.DRIVER_CLASS);
			con = DriverManager.getConnection(RegLogConstants.ORACLE_URL, RegLogConstants.ORACLE_USERNAME,
					RegLogConstants.ORACLE_PASSWORD);
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
}
