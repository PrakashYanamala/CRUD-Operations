package com.example.BankFetchAndOperations.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "BANK")
public class Bank {

	@Id
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	//@Id
	@Column(name = "ACCOUNTNUM")
	private long accountNum;

	@Column(name = "BALANCE")
	private double balance;

	@Column(name = "PINNUM")
	private int pinNum;

	@Column(name = "BANKNAME")
	private String bankName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPinNum() {
		return pinNum;
	}

	public void setPinNum(int pinNum) {
		this.pinNum = pinNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Bank [customerName=" + customerName + ", accountNum=" + accountNum + ", balance=" + balance
				+ ", pinNum=" + pinNum + ", bankName=" + bankName + "]";
	}
	
	
	
	

}
