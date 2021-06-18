package bankaccountapp;

public class Checking extends Account {

	// properties specific to CK
	private int debitCardNumber;
	private int debitCardPIN;

	// const
	public Checking() {

	}

	public Checking(String name, String SSN, double initDeposit) {
		super(name, SSN, initDeposit);
		accountNumber = "2" + accountNumber;
//		System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
//		System.out.println("NEW CHCKING ACCOUNT");

		setDebitCard();
	}
	
	@Override
	public void setRate() {
		//System.out.println("Implemented rate for Checking");
		rate = getBaseRate()*.15;
	}

	// methods specific to CK
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}

	public void showInfo() {
		System.out.println("**NEW CHCKING ACCOUNT**");
		super.showInfo();
		System.out.println("Checking Account Features [debitCardNumber=" + debitCardNumber + ", debitCardPIN="
				+ debitCardPIN + "RATE=" + rate + "%" +"]");
	}
}
