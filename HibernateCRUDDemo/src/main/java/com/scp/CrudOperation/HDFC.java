package com.scp.CrudOperation;

public class HDFC implements Bank{
	double HDFC_INTEREST=0.08;

	public double calculateInterest(double balance) {
		return balance*HDFC_INTEREST;
	}

	public String getBankName() {
		return "HDFC";
	}

	public int getIFSC() {
		return 2222;
	}

	public HDFC() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
