package com.example.Model;

import java.sql.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="STUDENTDATA")
public class Student {

	
	@Id
	@Column(name = "NAME")
	private String stName;
	
	//@Id
	@Column(name = "EMAIL")
	private String stMail;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "MOBILE")
	private Long mobileNum;
	
	/*
	 * @Column(name="DOB", nullable = true) private java.sql.Date DOB;
	 */
	@Column(name = "DOB")
	private Date dob;
	
	
	// Setters && getters 

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStMail() {
		return stMail;
	}

	public void setStMail(String stMail) {
		this.stMail = stMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	
	
	
	
	
	
	
}
