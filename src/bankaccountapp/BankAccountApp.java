package bankaccountapp;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {

		List<Account> accounts = new LinkedList<Account>();

		// TODO Auto-generated method stub

		Checking chkac1 = new Checking("Tom Wilson", "324121331", 1500.00);

		Savings sbac1 = new Savings("Rich Lowe", "445473219", 2500.00);

		System.out.println();
		sbac1.showInfo();
		System.out.println("---------------------------\n");
		chkac1.showInfo();
		System.out.println("---------------------------\n");

//		sbac1.deposit(5000);
//		sbac1.withdraw(200);
//		sbac1.transfer("Brokerage", 3000);

		sbac1.compound();

		// read csv
		System.out.println("\nReading from a NewBankAccounts.csv file");
		String file = "NewBankAccounts.csv";
		System.out.println("-- NEW ACCOUNTS --");
		try {
			List<String[]> newAccountHoder = utilities.CSV.read(file);
			for (String[] accH : newAccountHoder) {
				String name = accH[0];
				String SSN = accH[1];
				String accType = accH[2];
				double initDeposit = Double.parseDouble(accH[3]);
				// System.out.println("\t" + name + " " + SSN + " " + accType + " $" +
				// initDeposit);

				if (accType.equals("Savings")) {
					// System.out.println("OPEN A SAVINGS ACCOUNT");
					accounts.add(new Savings(name, SSN, initDeposit));
					System.out.println();
				} else if (accType.equals("Checking")) {
					// System.out.println("OPEN A CHECKING ACCOUNT");
					accounts.add(new Checking(name, SSN, initDeposit));
					System.out.println();
				} else {
					System.out.println("ERROR READING ACCOUNT TYPE");
				}

			}
			
			System.out.println("\nDisplay the account types:");
			for (Account acc : accounts) {
				System.out.println("\n--------------------------");
				acc.showInfo();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("COULD NOT FIND FILE !");
			e.printStackTrace();
		}

	}

}
