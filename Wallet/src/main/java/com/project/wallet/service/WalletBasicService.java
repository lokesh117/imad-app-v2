package com.project.wallet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.project.wallet.bean.Account;
import com.project.wallet.dao.IWalletAccess;
import com.project.wallet.dao.WalletAccess;
import com.project.wallet.exception.WalletException;

public class WalletBasicService implements IWalletBasicService {
	Account temp = new Account();
	IWalletAccess dao;
	 public WalletBasicService() {
		 dao = new WalletAccess();
		 
	}
	 LocalDate tDate = LocalDate.now();
	 static String namePattern = "[A-Z]{1}[a-z]{2,}";
	 static String numberPattern = "(\\d){10}";
	 static String passwordPattern = "[A-Z]{1}[a-z]{2,6}(\\d){1,4}(\\W){1}";
	
	 public  boolean validateCustName(String name)
	 {	if(name.matches(namePattern))
	 		return true;
	 	else
	 		return false;
	 }
	 
	 
	 public  boolean validateCustPhoneNumber(String number) {
			if(number.matches(numberPattern))
				return true;
			else
				return false;
		}
	 
	 
public boolean validateCustAge(int age)throws WalletException {
	if(age<=110&&age>=1)
		return true;
	else
		return false;
	
}

public  boolean validateCustPwd(String pwd) {
	if(pwd.matches(passwordPattern))
		return true;
	else
		return false;
}

public  boolean validateAmt(double amt) {
if(amt>0.00)
	return true;
else
	return false;
}

public int addAccDao(Account a) {
	return dao.accCreation(a);
}

public double depositDao(double money) {
	temp.setCustomerBal(temp.getCustomerBal()+money);
	temp.settDetails("Date :"+tDate+" Depsoited Amount :"+money+" Total Balance :"+temp.getCustomerBal());
	dao.updateDetails(temp.getAccountNumber(),temp);
	return temp.getCustomerBal();
}

public double withdrawDao(double money) {
	if(money<temp.getCustomerBal()) {
		temp.setCustomerBal(temp.getCustomerBal()-money);
		temp.settDetails("Date :"+tDate+" Amount Withdrawn :"+money+" Total Balance :"+temp.getCustomerBal());
		dao.updateDetails(temp.getAccountNumber(),temp);
		}
		else
			System.out.println(" Low Balance :( ");
		return temp.getCustomerBal();
}

public double showBalDao() {
	return temp.getCustomerBal();
}

public boolean checkLogin(int accNo) throws WalletException {
	temp =dao.loginUser(accNo);
	if(temp!=null)
	return true;
	else 
		return false;
}

public boolean checkPassword(String pwd) {
	if(temp.getCustomerPwd().matches(pwd))
		return true;
	else
		return false;
}

public String currentUser() {
	return temp.getCustomerName();
}

public boolean transferAmt(int toAccNo, double money) throws WalletException {
	Account ftTemp =new Account();
	if(temp.getCustomerBal()>=money) {
	ftTemp = dao.loginUser(toAccNo);
	if(ftTemp!=null)
	{
		ftTemp.setCustomerBal(ftTemp.getCustomerBal()+money);
		temp.setCustomerBal(temp.getCustomerBal()-money);
		temp.settDetails("Date :"+tDate+" Amount Transfered :"+money+" To Acc No: "+ftTemp.getAccountNumber()+" Total Balance :"+temp.getCustomerBal());
		ftTemp.settDetails("Date :"+tDate+" Depsoited Amount :"+money+" From Acc No: "+temp.getAccountNumber()+" Total Balance :"+ftTemp.getCustomerBal());
		dao.updateDetails(temp.getAccountNumber(), temp);
		dao.updateDetails(ftTemp.getAccountNumber(), ftTemp);
		return true;
	}
	
	
}
	else if(temp.getCustomerBal()<money)
	{
		System.out.println("Low Balance to transfer");
	}
	
	else
		System.out.println("No such user account");
	return false;
}

public void printTransdetails() {
	ArrayList<String> tempDetails = new ArrayList<String>();
	tempDetails = temp.gettDetails();
	Stream<String> printList = tempDetails.stream();
	printList.forEach(System.out::println);
	
}


	
}



