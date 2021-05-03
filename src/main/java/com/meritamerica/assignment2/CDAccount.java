package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount {
	private double Balance;
	private double InterestRate;
	private int Term;
	private java.util.Date StartDate;
	private long AccountNumber;
	private double futureValue11;
	private CDOffering offering;
	 
//Constructor

	
	public CDAccount(CDOffering offering, double balance) {
		super();
		Balance = balance;
		this.offering = offering;
	}

	public double getBalance() {
		return Balance;
	}

	public CDAccount futureValue1() {
		return (null);
	}

	double getInterestRate() {
				return InterestRate;
	}

	CDAccount getTerm() {
				return null;
	}
	
	
	
}
