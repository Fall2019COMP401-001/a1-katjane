package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		// Your code goes here.

		int itemsInStore = scan.nextInt();
		String[] itemNames = new String[itemsInStore];
		double[] itemPrices = new double[itemsInStore];
		int[] itemsBoughtBy = new int[itemsInStore];
		int[] itemsNumBought = new int[itemsInStore];
		// all of the "item" arrays are indexed the same way. 
		
		for (int i = 0; i < itemsInStore; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}

		int numCustomers = scan.nextInt();
		// customers can be tracked by their 'J'
		String[] firstNames = new String[numCustomers];
		String[] lastNames = new String[numCustomers];
		int[] numItemsBought = new int[numCustomers];
		double[] amountSpent = new double[numCustomers];
		// so that customers are not counted as more than one person:
//		boolean[] itemsCustomerCounted = new boolean[numCustomers];
//		
//		for (int e = 0; e < itemsCustomerCounted.length; e++) {
//			itemsCustomerCounted[e] = false;
//		}
		
		// this loop runs for each customer 
		for (int j = 0; j < numCustomers; j++) {
			// all of these arrays are updated for each customer
			firstNames[j] = scan.next();
			lastNames[j] = scan.next();
			numItemsBought[j] = scan.nextInt();
			
			// these arrays are customer-specific
			int[] quantOfItem = new int[numItemsBought[j]];
			String[] nameOfItem = new String[numItemsBought[j]];
			
			// this loop runs for each item that an individual customer buys 
			for (int k = 0; k < numItemsBought[j]; k++) {
				quantOfItem[k] = scan.nextInt();
				nameOfItem[k] = scan.next();

				// this for loop checks each item against the store's list, and 
				// performs the math to add up the amount spent on that item, and add
				// it to the customer's "amountSpent" total. 
				for (int l = 0; 0 < itemsInStore; l++) {
					if (nameOfItem[k].contentEquals(itemNames[l])) {
						double cost = itemPrices[l] * quantOfItem[k];
						amountSpent[j] += cost;
//						itemsBoughtBy[l] = itemsBoughtBy[l] + 1;
						itemsNumBought[l] += quantOfItem[k];
						
						if (k > 0) {
							if (!(nameOfItem[k].contentEquals(nameOfItem[k - 1]))) {
								itemsBoughtBy[l] = itemsBoughtBy[l] + 1;
							}
						} else {
							itemsBoughtBy[l] = itemsBoughtBy[l] + 1;
						}
//						if (!(nameOfItem[k].contentEquals(nameOfItem[k - 1])) && k > 0) {
//							itemsBoughtBy[l] = itemsBoughtBy[l] + 1;
//						} else if (k <= 0) {
//							itemsBoughtBy[l] = itemsBoughtBy[l] + 1;
//						}
//						if (!itemsCustomerCounted[j]) {
//							itemsBoughtBy[l] = itemsBoughtBy[l] + 1;
//							itemsCustomerCounted[j] = true;
//						}
						break;
					}
				}
				
				
			}
		}
		
		for (int q = 0; q < itemsInStore; q++) {
			if (itemsNumBought[q] < 1) {
				System.out.println("No customers bought " + itemNames[q]);
			} else {
				System.out.println(itemsBoughtBy[q] + " customers bought " + itemsNumBought[q]
						+ " " + itemNames[q]);
			}
		}
	}

}

// need to record information for every item- how much of it was bought, 
// how many people bought it, etc. So along with the synched customer arrays,
// I need a synched item array. items, itemBoughtBy, itemNumBought. 
// also, need an if/else, where if itemNumBought is 0, then it will print the 
// "no customers bought ITEM",  and else it'll print the number bought, etc 
