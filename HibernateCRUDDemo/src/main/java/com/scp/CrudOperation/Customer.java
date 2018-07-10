package com.scp.CrudOperation;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
public class Customer {
	@Id
	// @GeneratedValue(strategy=GenerationType.TABLE)
	// int primaryKey;
	private int custId;
	private String custName;
	private int age;
	@Enumerated(EnumType.STRING)
	private parameter bankType;
	private double balance;
	private double interest;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int custId, String custName, int age, parameter bankType, double balance, double interest) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.age = age;
		this.bankType = bankType;
		this.balance = balance;
		this.interest = getInterest();
		;

	}

	public int getCustId() {
		if (custId > 0)
			return custId;
		return 0;
	}

	public void setCustId(int custId) {
		if (custId > 0)
			this.custId = custId;
		else
			this.custId = 0;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterest() {
		AbstractFactory obj1 = new SBIFactory();
		Bank Ob = BankFactoryInstance.getBankInstance(obj1);
		double interest = Ob.calculateInterest(getBalance());
		return interest;
	}

	public void setInterest(double interest) {
		AbstractFactory obj1 = new SBIFactory();
		Bank Ob = BankFactoryInstance.getBankInstance(obj1);

		if (Ob instanceof SBI) {
			SBI SBIOb = (SBI) Ob;
			this.interest = SBIOb.calculateInterest(getBalance());
		}

		else if (Ob instanceof ICICI) {
			ICICI ICICIOb = (ICICI) Ob;
			this.interest = ICICIOb.calculateInterest(getBalance());
		}

		else if (Ob instanceof HDFC) {
			HDFC HDFCOb = (HDFC) Ob;
			this.interest = HDFCOb.calculateInterest(getBalance());
		}

	}

	public parameter getBankType() {

		return bankType;
	}

	public void setBankType(parameter bankType) {
		this.bankType = bankType;
	}

	@Override
	public String toString() {
		return "\nCustomer [custId=" + custId + ", custName=" + custName + ", age=" + age + ", bankType=" + bankType
				+ ", balance=" + balance + ", interest=" + getInterest() + "]";
	}

}
