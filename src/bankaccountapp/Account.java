package bankaccountapp;

public abstract class Account implements IBaseRate {

	// common prop for SB and CK accounts
	String name;
	String SSN;
	double balance;

	static int index = 10000;
	
	protected String accountNumber;
	protected double rate;

	// const to set base properties
	public Account() {
	}

	public Account(String name, String SSN, double initDeposit) {
		System.out.println("NAME: " + name);
		System.out.print("NEW ACCOUNT :");
		System.out.println("SSN :" + SSN);
		System.out.println("Initial deposit: " + initDeposit);

		this.name = name;
		this.SSN = SSN;
		balance = initDeposit;

		// set account no.
		index++;
		this.accountNumber = setAccountNumber();
		// System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
		// System.out.println(getBaseRate());

		setRate();
	}

	public abstract void setRate();

	private String setAccountNumber() {
		String lastTwoOfSSN = SSN.substring(SSN.length() - 2, SSN.length());
		int uniqueID = index;
		int randN = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randN;
	}
	
	public void compound() {
		double accInt = balance	* (rate/100);
		balance = balance + accInt;
		System.out.println("Accured Interest $"+accInt);
		printBalance();
	}

	// list common methods - transaction
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}

	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();

	}

	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Tranfering $" + amount + " to " + toWhere);
		printBalance();

	}

	public void printBalance() {
		System.out.println("\tYour balance is now $" + balance);
	}

	public void showInfo() {
		System.out.println("Account [name=" + name + ", SSN=" + SSN + ", balance=" + balance + ", accountNumber="
				+ accountNumber + "]");
	}
}
