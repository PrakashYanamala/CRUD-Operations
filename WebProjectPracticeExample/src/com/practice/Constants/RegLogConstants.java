package com.practice.Constants;

public class RegLogConstants {

	
	public static final String DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ORACLE_USERNAME="system";
	public static final String ORACLE_PASSWORD="java";
	public static final String STUDENTDATA_INSERT="INSERT INTO STUDENTDATA VALUES(?,?,?,?,?)";
	public static final String STUDENTDATA_SELECT="SELECT * FROM STUDENTDATA WHERE EMAIL=? AND PASSWORD=?";
	
}
