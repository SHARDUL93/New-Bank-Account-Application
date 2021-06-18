package bankaccountapp;

public class Savings extends Account {

	// properties specific to SB
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;

	// const
	public Savings() {

	}

	public Savings(String name, String SSN, double initDeposit) {
		super(name, SSN, initDeposit);
		accountNumber = "1" + accountNumber;
//		System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
//		System.out.println("NEW SAVINGS ACCOUNT");

		setSafetyDepositBox();
	}

	@Override
	public void setRate() {
		//System.out.println("Implemented rate for Savings");
		rate = getBaseRate() - .25;
	}

	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
		// System.out.println(safetyDepositBoxID);
	}

	// methods specific to SB
	public void showInfo() {
		System.out.println("**NEW SAVINGS ACCOUNT**");
		super.showInfo();
		System.out.println("Savings Account Features [safetyDepositBoxID=" + safetyDepositBoxID
				+ ", safetyDepositBoxKey=" + safetyDepositBoxKey + "RATE=" + rate + "%" + "]");
	}

}
