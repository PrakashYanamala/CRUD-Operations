package com.tcs.Costants;

public class RegLogConstants {

	public  static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	public  static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public  static final String ORACLE_USERNAME = "system";
	public  static final String ORACLE_PASSWORD = "java";
	public  static final String USERTABLE_INSERT = "INSERT INTO USERTABLE VALUES(?,?,?,?,?)";
	public  static final String USERTABLE_SELECT = "SELECT * FROM USERTABLE WHERE EMAIL=? AND PASSWORD=? ";
	public  static final String USERTABLE_SELECT1 = "SELECT * FROM USERTABLE WHERE NAME=? AND EMAIL=?  ";
	public  static final String USERTABLE_UPDATE = "UPDATE USERTABLE SET PASSWORD=?  WHERE NAME=? AND EMAIL=?";
}
