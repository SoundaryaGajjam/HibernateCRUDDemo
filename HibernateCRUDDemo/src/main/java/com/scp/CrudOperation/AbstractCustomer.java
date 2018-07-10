package com.scp.CrudOperation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public interface AbstractCustomer {
	List listOfCust = new ArrayList<>();

	public abstract boolean addCustomer(Customer ob);

	public abstract List getAllCustomer(Session s1, Transaction tr1);

	public abstract boolean deleteCustomer(int custId, Session s1, Transaction tr1);

	public abstract Customer getCustomer(int custId, Session s1, Transaction tr1);

	public abstract void updateCustomer(List listOfCust, Customer custOb, Session s1, Transaction tr1);

}