package com.scp.CrudOperation;

public class ICICIFactory implements AbstractFactory {

	public Bank getBankFactory() {
		return new ICICI();
	}

}
