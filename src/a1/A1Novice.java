package a1;

import java.util.Scanner;
import java.text.DecimalFormat;

public class A1Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		int numCustomers = scan.nextInt();
		for (int i = 0; i < numCustomers; i++) {
			String firstName = scan.next().charAt(0) + ". ";
			String lastName = scan.next() + ": ";
			int numItems = scan.nextInt();
			double totalSpent = 0.0;
			String totalSpentToPrint = "";
			for (int j = 0; j < numItems; j++) {
				int quantItem = scan.nextInt();

				String nameItem = scan.next();
				double itemPrice = scan.nextDouble();
				double spentOnItem = quantItem * itemPrice;
				totalSpent = totalSpent + spentOnItem;
				totalSpentToPrint = df.format(totalSpent);

			}
			
			System.out.println(firstName + lastName + totalSpentToPrint);

		}
	}
}