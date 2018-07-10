package com.scp.CrudOperation;

public class ICICI implements Bank {
	double ICICI_INTEREST=0.09;

	public double calculateInterest(double balance) {
		return balance*ICICI_INTEREST;
	}

	public String getBankName() {
		return "ICICI";
	}

	public int getIFSC() {
		return 3333;
	}

	public ICICI() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
