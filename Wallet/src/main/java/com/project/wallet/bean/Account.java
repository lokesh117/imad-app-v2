package com.project.wallet.bean;

import java.util.ArrayList;

public class Account {
	
	private int accountNumber;
	private String customerName;
	private String customerPhoneNo;
	private int customerAge;
	private double customerBal;
	static private int accNumGen = 10100;
	private String customerPwd;
	ArrayList<String> tDetails = new ArrayList<String>();
	public ArrayList<String> gettDetails() {
		return tDetails;
	}
	public void settDetails(String getDetails) {
		this.tDetails.add(getDetails);
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber() {
		this.accountNumber = accNumGen++;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public double getCustomerBal() {
		return customerBal;
	}
	public void setCustomerBal(double customerBal) {
		this.customerBal = customerBal;
	}
	
	
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	
	
	
	
	

}
