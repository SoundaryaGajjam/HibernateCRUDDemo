package com.scp.CrudOperation;

public class SBIFactory implements AbstractFactory{

	public Bank getBankFactory() {
		return new SBI();
	}

}
