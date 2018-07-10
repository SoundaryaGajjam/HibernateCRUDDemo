package com.scp.CrudOperation;

public class BankFactoryInstance {
	public static Bank getBankInstance(AbstractFactory aFactory){
			return aFactory.getBankFactory();
		
		
	}
}
