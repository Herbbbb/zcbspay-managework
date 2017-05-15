package com.zcbspay.platform.manager.exception;

public class ContractException extends Exception{

	private static final long serialVersionUID = 1273275676402927110L;
	
	public String message;
	public ContractException(String message){
		this.message = message;
	}
	public String getMessage(){
		return this.message;
	}

}
