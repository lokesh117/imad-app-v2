package com.project.wallet.exception;

public class WalletException extends Exception {

	String message;
	
	public WalletException(String s) {
		super(s);
	}
	
	public String getMessage()
	{
		return message;
	}
	
	
}
