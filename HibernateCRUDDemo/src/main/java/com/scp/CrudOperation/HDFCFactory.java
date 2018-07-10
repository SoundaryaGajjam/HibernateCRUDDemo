package com.scp.CrudOperation;

public class HDFCFactory implements AbstractFactory{

	public Bank getBankFactory() {
		return new HDFC();
	}

}
