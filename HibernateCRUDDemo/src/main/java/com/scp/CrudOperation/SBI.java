package com.scp.CrudOperation;

public class SBI implements Bank{
	double SBI_INTEREST=0.07;
	
	public double calculateInterest(double balance) {
		return balance*SBI_INTEREST;
		
	}

	public String getBankName() {
		return "SBI";
	}

	public int getIFSC() {
		return 1111;
	}

	public SBI() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
