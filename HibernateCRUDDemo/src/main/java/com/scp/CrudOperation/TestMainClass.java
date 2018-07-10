package com.scp.CrudOperation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestMainClass {
	static Scanner sc = new Scanner(System.in);
	static Customer custOb = null;
	static AbstractCustomer abs = new CustomerImplementation();
	static SessionFactory sFactory = HibernateUtil.getSessionFactory();

	static Session s1 = null;
	static Transaction tr1 = null;

	public static void main(String[] args) {
		String opt;
		int custId;
		List listOfCust;
		do {
			s1 = sFactory.openSession();
			tr1 = s1.beginTransaction();
			System.out.println(
					"1.Add Customer\n2.Update Customer\n3.Get Particular Customer based on Id\n4.Get All Customer Details\n5.Delete Customer based on Id\n6.Calculate Interest\n7.SBI Total Interest\n8.ICICI Total Interest\n9.HDFC Interest\n10.Exit\n");
			System.out.println("Enter ur choice : ");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				custOb = CustomerUtil.inputFromUser();
				abs.addCustomer(custOb);
				s1.save(custOb);
				HibernateUtil.FlushNCOmmit(s1, tr1);
				break;
			case 2:
				listOfCust = abs.getAllCustomer(s1, tr1);
				System.out.println("Enter Customer Id which U want  to update : ");
				custId = sc.nextInt();
				Transaction tr2 = s1.beginTransaction();
				custOb = abs.getCustomer(custId, s1, tr2);
				Transaction tr3 = s1.beginTransaction();
				abs.updateCustomer(listOfCust, custOb, s1, tr3);
				break;
			case 3:
				System.out.println("Enter Customer Id which U want : ");
				custId = sc.nextInt();
				custOb = abs.getCustomer(custId, s1, tr1);
				System.out.println(custOb);
				break;
			case 4:
				listOfCust = abs.getAllCustomer(s1, tr1);
				System.out.println(listOfCust);
				break;
			case 5:
				System.out.println("Enter cust Id which u want to delete : ");
				custId = sc.nextInt();
				abs.deleteCustomer(custId, s1, tr1);
				break;
			case 6:
				System.out.println("Enter cust id which u want to claculate the interest : ");
				custId = sc.nextInt();
				custOb = s1.get(Customer.class, custId);
				HibernateUtil.FlushNCOmmit(s1, tr1);
				if (null != custOb && (parameter.SBI.equals(custOb.getBankType())))
					CustomerUtil.SBIBank(custOb);
				else if (null != custOb && (parameter.HDFC.equals(custOb.getBankType())))
					CustomerUtil.HDFCBank(custOb);
				else if (null != custOb && (parameter.ICICI.equals(custOb.getBankType())))
					CustomerUtil.ICICIBank(custOb);
				break;
			case 7:
				listOfCust = abs.getAllCustomer(s1, tr1);
				CustomerUtil.SBITotalInterest(listOfCust);
				break;
			case 8:
				listOfCust = abs.getAllCustomer(s1, tr1);
				CustomerUtil.ICICITotalInterest(listOfCust);
				break;

			case 9:
				listOfCust = abs.getAllCustomer(s1, tr1);
				CustomerUtil.HDFCTotalInterest(listOfCust);
				break;
			case 10:
				System.out.println("Sorry ... U r exited");
				System.exit(0);
				break;
			default:
				System.out.println("Ooopss...U r entred wrong choice :-) ");
			}
			System.out.println("If U want to continue press (y/n) : ");
			opt = sc.next();
		} while ("y".equals(opt));

	}

}
