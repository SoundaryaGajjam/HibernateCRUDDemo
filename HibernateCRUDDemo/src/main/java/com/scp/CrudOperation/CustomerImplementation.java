package com.scp.CrudOperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CustomerImplementation implements AbstractCustomer {
	List listOfCust = new ArrayList<>();
	Customer custOb = null;
	static Scanner sc = new Scanner(System.in);

	@Override
	public boolean addCustomer(Customer ob) {
		listOfCust.add(ob);
		return true;
	}

	public List getAllCustomer(Session s1, Transaction tr1) {
		Query query = s1.createQuery("from Customer");
		HibernateUtil.FlushNCOmmit(s1, tr1);
		return query.list();
	}

	public boolean deleteCustomer(int custId, Session s1, Transaction tr1) {
		// Transaction tr2=s1.beginTransaction();
		//
		listOfCust = getAllCustomer(s1, tr1);
		// System.out.println(listOfCust);
		Iterator itr = listOfCust.iterator();
		while (itr.hasNext()) {
			custOb = (Customer) itr.next();
			if (null != custOb && (custOb.getCustId() == custId)) {
				listOfCust.remove(custOb);
				// System.out.println(custOb);
				Transaction tr3 = s1.beginTransaction();
				s1.delete(custOb);
				HibernateUtil.FlushNCOmmit(s1, tr3);
				return true;
			}
		}
		return false;
	}

	@Override
	public Customer getCustomer(int custId, Session s1, Transaction tr1) {
		custOb = s1.get(Customer.class, custId);
		HibernateUtil.FlushNCOmmit(s1, tr1);
		if (null != custOb)
			return custOb;
		return null;
	}

	@Override
	public void updateCustomer(List listOfCust, Customer custOb, Session s1, Transaction tr1) {
		double balance = 0.0;
		if (null != custOb && (listOfCust.contains(custOb))) {
			System.out.println("Enter name for updatetion : ");
			String name = sc.next();
			custOb.setCustName(name);
			System.out.println("1.Deposit\n2.Withdrawl");
			System.out.println("Enter ur choice : ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter balance : ");
				balance = sc.nextDouble();
				balance = custOb.getBalance() + balance;
				custOb.setBalance(balance);
				custOb.setInterest(custOb.getInterest());
				break;
			case 2:
				System.out.println("Enter balance : ");
				balance = sc.nextDouble();
				balance = custOb.getBalance() - balance;
				custOb.setBalance(balance);
				custOb.setInterest(custOb.getInterest());
				break;
			default:
				System.out.println("Sorry...Invalid choice !!!");
			}

			s1.update(custOb);
			HibernateUtil.FlushNCOmmit(s1, tr1);
		}

	}

}
