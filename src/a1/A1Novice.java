package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
//		Scanner scanny = new Scanner(System.in);
//		
//		int numCustomers = scanny.nextInt();
//		for (int i = 0; i < numCustomers; i++) {
//			String firstName = scanny.next();
//			char firstChar = firstName.charAt(0);
//			String lastName = scanny.next();
//			int totalSpent = 0;
//			int totalItems = scanny.nextInt();
//			for (int j = 0; j < totalItems; j++) {
//				int quantOfItem = scanny.nextInt();
//				String itemName = scanny.next();
//				double priceOfItem = scanny.nextDouble();
//				totalSpent += quantOfItem * priceOfItem;
//			}
//			System.out.println(firstChar + ". " + lastName + ": " + totalSpent);
		
		Scanner scan = new Scanner(System.in);
		
		int numCustomers = scan.nextInt();
		String[] stats = new String[numCustomers];
		for (int i = 0; i < numCustomers; i++) {
			// problem is somewhere after this line, within last for-loop?
			String firstName = scan.next().charAt(0) + ". ";
			String lastName = scan.next() + ": ";
			int numItems = scan.nextInt();
			double totalSpent = 0.0;
			for (int j = 0; j < numItems; j++) {
				int quantItem = scan.nextInt();
				
				//here the problem is!
				String nameItem = scan.next();
				// the problem is this line!!
				// it only occurs with the very last grocery item, it's like 
				// the scanner doesn't read the last line 
				
				System.out.println("No problems yet!");
				double itemPrice = scan.nextDouble();
				double spentOnItem = quantItem * itemPrice;
				totalSpent = totalSpent + spentOnItem;
			}
			stats[i] = firstName + lastName + totalSpent;
			System.out.println(firstName + lastName + totalSpent);
			
		
		}
		
		for (int i = 0; i < numCustomers; i++) {
			System.out.println(stats[i]);
		}
		
		// Your code goes here.
	}
	
	// You can define / use static helper methods here.
}

//4
//Carrie Brownstein 3
//2 Banana 0.75
//1 Orange 1.25
//2 Milk 3.15
//Corin Tucker 2
//3 Banana 0.75
//2 Sponge 1.15
//Janet Weiss 1
//5 Salami 2.50
//Monseuir Roach 4
//2 Salami 2.50
//2 Banana 0.75
//1 Orange 1.25
//2 Milk 3.15

// would produce: 

//C. Brownstein: 9.05
//C. Tucker: 4.55
//J. Weiss: 12.50
