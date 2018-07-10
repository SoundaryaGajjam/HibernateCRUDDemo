package com.scp.CrudOperation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerUtil {
	static Scanner sc = new Scanner(System.in);
	static Customer custObj = null;
	static AbstractCustomer abs = new CustomerImplementation();
	static SessionFactory sFactory = HibernateUtil.getSessionFactory();

	static Session s1 = null;
	static Transaction tr1 = null;

	public static void HDFCTotalInterest(List listOfCust) {
		double hdfcTotalInterest = 0.0;
		Iterator itr = listOfCust.iterator();
		while (itr.hasNext()) {
			custObj = (Customer) itr.next();
			if ((null != custObj && (listOfCust.contains(custObj))) && (parameter.HDFC.equals(custObj.getBankType())))
				hdfcTotalInterest = hdfcTotalInterest + custObj.getInterest();
		}
		System.out.println("Total HDFC Bank Interest : " + hdfcTotalInterest);
	}

	public static void ICICITotalInterest(List listOfCust) {
		double iciciTotalInterest = 0.0;
		Iterator itr = listOfCust.iterator();
		while (itr.hasNext()) {
			custObj = (Customer) itr.next();
			if (null != custObj && (listOfCust.contains(custObj)) && (parameter.ICICI.equals(custObj.getBankType())))
				iciciTotalInterest = iciciTotalInterest + custObj.getInterest();

		}

		System.out.println("Total ICICI Bank Interest : " + iciciTotalInterest);

	}

	public static void SBITotalInterest(List listOfCust) {
		double sbiTotalInterest = 0.0;

		Iterator itr = listOfCust.iterator();
		while (itr.hasNext()) {
			custObj = (Customer) itr.next();
			if (null != custObj && (listOfCust.contains(custObj)) && (parameter.SBI.equals(custObj.getBankType()))) {
				sbiTotalInterest = sbiTotalInterest + custObj.getInterest();
			}
		}
		System.out.println("Total  SBI Bank Interest : " + sbiTotalInterest);

	}

	public static void HDFCBank(Customer custOb) {
		double bal = custOb.getBalance();
		AbstractFactory aFactory = new HDFCFactory();
		HDFC hdfcObj = (HDFC) BankFactoryInstance.getBankInstance(aFactory);
		double interest = hdfcObj.calculateInterest(bal);
		custOb.setInterest(interest);
		System.out.println("Bank Name : " + hdfcObj.getBankName());
		System.out.println("IFSC Code : " + hdfcObj.getIFSC());
		System.out.println("Interest : " + custOb.getInterest());
	}

	public static void ICICIBank(Customer custOb) {
		double bal = custOb.getBalance();
		AbstractFactory aFactory = new ICICIFactory();
		ICICI iciciObj = (ICICI) BankFactoryInstance.getBankInstance(aFactory);
		double interest = iciciObj.calculateInterest(bal);
		custOb.setInterest(interest);
		System.out.println("Bank Name : " + iciciObj.getBankName());
		System.out.println("IFSC Code : " + iciciObj.getIFSC());
		System.out.println("Interest : " + custOb.getInterest());
	}

	public static void SBIBank(Customer custOb) {

		AbstractFactory aFactory = new SBIFactory();
		SBI sbiObj = (SBI) BankFactoryInstance.getBankInstance(aFactory);
		double bal = custOb.getBalance();
		double interest = sbiObj.calculateInterest(bal);
		custOb.setInterest(interest);
		System.out.println("Bank Name : " + sbiObj.getBankName());
		System.out.println("IFSC Code : " + sbiObj.getIFSC());
		System.out.println("Interest : " + custOb.getInterest());
	}

	public static Customer inputFromUser() {

		System.out.println("Enter custId : ");
		int custId = sc.nextInt();
		System.out.println("Enter Name : ");
		String name = sc.next();
		System.out.println("Enter age : ");
		int age = sc.nextInt();
		System.out.println("Enter Bank Name (SBI/HDFC/ICICI) : ");
		String str = sc.next();
		parameter bankName = parameter.valueOf(str);
		System.out.println("Enter initial Balance : ");
		double bal = sc.nextDouble();
		return new Customer(custId, name, age, bankName, bal, 0);
	}

}

enum parameter {
	SBI, ICICI, HDFC;
}
