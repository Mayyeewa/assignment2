package com.meritamerica.assignment2;

public class AccountHolder {
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	CheckingAccount checking;
	SavingsAccount savings;

	public AccountHolder() {
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.ssn = "";
		this.checking = new CheckingAccount(0.0);
		this.savings = new SavingsAccount(0.0);
	}

	private String ssn1;
	CheckingAccount[] checkingArray = new CheckingAccount[0];
	SavingsAccount[] savingsArray = new SavingsAccount[0];
	CDAccount[] cdAccountArray = new CDAccount[0];

// Constructor for an account holder
	public AccountHolder(String first, String middle, String last, String ssn) {
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.ssn = ssn;
	}

	public void addCheckingAccount(double openBalance) {
		if (getCheckingBalance() + getSavingsBalance() + openBalance >= 250000) {
			System.out.println("Cannot open a new Checking Account because total balance of accounts is too high.");
			return;
		}
		CheckingAccount newA = new CheckingAccount(openBalance);
		CheckingAccount[] newCheckingArray = new CheckingAccount[checkingArray.length + 1];
		for (int i = 0; i < newCheckingArray.length - 1; i++) {
			newCheckingArray[i] = checkingArray[i];
		}
		checkingArray = newCheckingArray;
		checkingArray[checkingArray.length - 1] = newA;
	}

// Method to add checking account to an account holder
	public void addCheckingAccount(CheckingAccount checkingAccount) {
		if (checkingAccount.getBalance() + getCheckingBalance() + getSavingsBalance() >= 250000) {
			System.out.println("Cannot open a new Checking Account because total balance of accounts is too high.");
			return;
		}
		CheckingAccount[] newCheckingArray = new CheckingAccount[checkingArray.length + 1];
		for (int i = 0; i < newCheckingArray.length - 1; i++) {
			newCheckingArray[i] = checkingArray[i];
		}
		checkingArray = newCheckingArray;
		checkingArray[checkingArray.length - 1] = checkingAccount;
	}

// Method for finding aggregate balance of checking accounts
	public double getCheckingBalance() {
		double total = 0.0;
		int i;
		for (i = 0; i < checkingArray.length; i++) {
			total += checkingArray[i].getBalance();
		}
		return total;
	}

	public AccountHolder(String firstName, String middleName, String lastName, String SSN,
			double checkingAccountOpeningBalance, double savingsAccountOpeningBalance) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.setSsn1(ssn);
		checking = new CheckingAccount(checkingAccountOpeningBalance);
		savings = new SavingsAccount(savingsAccountOpeningBalance);
// Method for adding savings account to account holder
	}

	public void addSavingsAccount(double openBalance) {
		if (getCheckingBalance() + getSavingsBalance() + openBalance >= 250000) {
			System.out.println("Cannot open a new Savings Account because total balance of accounts is too high.");
			return;
		}
		SavingsAccount newA = new SavingsAccount(openBalance);
		SavingsAccount[] newSavingsArray = new SavingsAccount[savingsArray.length + 1];
		for (int i = 0; i < newSavingsArray.length - 1; i++) {
			newSavingsArray[i] = savingsArray[i];
		}
		savingsArray = newSavingsArray;
		savingsArray[savingsArray.length - 1] = newA;
	}

	public String getFirstName() {
		return this.firstName;
	}

// Method for adding savings account to account holder
	public void addSavingsAccount(SavingsAccount savingsAccount) {
		if (savingsAccount.getBalance() + getCheckingBalance() + getSavingsBalance() >= 250000) {
			System.out.println("Cannot open a new Savings Account because total balance of accounts is too high.");
			return;
		}
		SavingsAccount[] newSavingsArray = new SavingsAccount[savingsArray.length + 1];
		for (int i = 0; i < newSavingsArray.length - 1; i++) {
			newSavingsArray[i] = savingsArray[i];
		}
		savingsArray = newSavingsArray;
		savingsArray[savingsArray.length - 1] = savingsAccount;
	}

// Returns a savings account
	public SavingsAccount[] getSavingsAccounts() {
		return savingsArray;
	}

// Returns the total number of savings accounts
	public int getNumberOfSavingsAccounts() {
		return savingsArray.length;
	}

// Returns the total balance in savings accounts
	public double getSavingsBalance() {
		double total = 0.0;
		for (SavingsAccount balance : savingsArray) {
			total += balance.getBalance();
		}
		return total;
	}

// Adds a CDAccount to the account holder
	public void addCDAccount(CDOffering offering, double openBalance) {
		CDAccount newA = new CDAccount(offering, openBalance);
		CDAccount[] newCDArray = new CDAccount[cdAccountArray.length + 1];
		for (int i = 0; i < newCDArray.length - 1; i++) {
			newCDArray[i] = cdAccountArray[i];
		}
		cdAccountArray = newCDArray;
		cdAccountArray[cdAccountArray.length - 1] = newA;
	}

	public void setFirstName1(String firstName) {
		this.firstName = firstName;
	}

	public void addCDAccount(CDAccount cdAccount) {
		CDAccount[] newCDArray = new CDAccount[cdAccountArray.length + 1];
		for (int i = 0; i < newCDArray.length - 1; i++) {
			newCDArray[i] = cdAccountArray[i];
		}
		cdAccountArray = newCDArray;
		cdAccountArray[cdAccountArray.length - 1] = cdAccount;
	}
	

	public CDAccount[] getCDAccounts() {
		return cdAccountArray;
	}

	public int getNumberOfCDAccounts() {
		return cdAccountArray.length;
	}

	public double getCDBalance() {
		double total = 0.0;
		for (CDAccount balance : cdAccountArray) {
			total += balance.getBalance();
		}
		return total;
	}

	public double getCombinedBalance() {
		return getCDBalance() + getSavingsBalance() + getCheckingBalance();
	}

	public void setFirstName(String first) {
		this.firstName = first;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getssn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public CheckingAccount[] getCheckingAccounts() {
		return checkingArray;
	}

	public int getNumberOfCheckingAccounts() {
		return checkingArray.length;
	}

	@Override
	public String toString() {
		return "Name: " + getFirstName() + " " + getMiddleName() + " " + getLastName() + "\n" + "SSN: " + getssn()
				+ "\n" + getCheckingAccounts().toString() + "\n" + getSavingsAccounts().toString();
	}

	public SavingsAccount getSavings() {
		return savings;
	}

	public void setSavings(SavingsAccount savings) {
		this.savings = savings;
	}

	public String getSsn() {
		return ssn;
	}

	public CheckingAccount getChecking() {
		return checking;
	}

	public CheckingAccount[] getCheckingArray() {
		return checkingArray;
	}

	public SavingsAccount[] getSavingsArray() {
		return savingsArray;
	}

	public CDAccount[] getCdAccountArray() {
		return cdAccountArray;
	}

	public String getSsn1() {
		return ssn1;
	}

	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}

}