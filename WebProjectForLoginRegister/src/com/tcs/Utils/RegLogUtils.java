package com.tcs.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tcs.Costants.RegLogConstants;

public class RegLogUtils {

	public Connection createConnection() {
		
		Connection con = null;
		
		try {
			Class.forName(RegLogConstants.DRIVER_CLASS);
			con = DriverManager.getConnection(RegLogConstants.ORACLE_URL, RegLogConstants.ORACLE_USERNAME,
					RegLogConstants.ORACLE_PASSWORD);
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
