package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		// Your code goes here.
		
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		int itemsInStore = scan.nextInt();
		// items in store are tracked by their 'I'
		String[] itemNames = new String[itemsInStore];
		double[] itemPrices = new double[itemsInStore];
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
		for (int j = 0; j < numCustomers; j++) {
			firstNames[j] = scan.next();
			lastNames[j] = scan.next();
			numItemsBought[j] = scan.nextInt();
			
			int[] quantOfItem = new int[numItemsBought[j]];
			// the individual items can be tracked by "K"
			String[] nameOfItem = new String[numItemsBought[j]];
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
						break;
					}
				}
			}
		}
		
		String finalBiggest = findBiggest(firstNames, lastNames, amountSpent);
		String finalSmallest = findSmallest(firstNames, lastNames, amountSpent);
		String finalAverage = findAverage(amountSpent);
		System.out.println(finalBiggest);
		System.out.println(finalSmallest);
		System.out.println(finalAverage);
		
	}

	// You can define / use static helper methods here.
	
	public static String findBiggest(String[] firsts, String[] lasts, double[] totals) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		int biggestIndex = 0;
		double biggestAmount = 0.00;
		for (int m = 0; m < totals.length; m++) {
			if (totals[m] > biggestAmount) {
				biggestAmount = totals[m];
				biggestIndex = m;
			} else if (Math.abs(totals[m] - biggestAmount) < 0.0001) {
				return "TIE, OH NO";
			}
		}
		
		String biggestAmountToPrint = df.format(biggestAmount);
		String forReturn = "Biggest: " + firsts[biggestIndex] + " " + lasts[biggestIndex] + " ("
				+ biggestAmountToPrint + ")";
		return forReturn;
	}
	
	public static String findSmallest(String[] firsts, String[] lasts, double[] totals) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		int smallestIndex = 0; 
		double smallestAmount = totals[0];
		for (int n = 1; n < totals.length; n++) {
			if (totals[n] < smallestAmount) {
				smallestAmount = totals[n];
				smallestIndex = n;
			} else if (Math.abs(totals[n] - smallestAmount) < 0.0001) {
				return "TIE, OH NO";
			}
		}
		
		String smallestAmountToPrint = df.format(smallestAmount);
		String forReturn = "Smallest: " + firsts[smallestIndex] + " " + lasts[smallestIndex] + 
				" (" + smallestAmountToPrint + ")";
		return forReturn;
	}
	
	public static String findAverage(double[] totals) {
		DecimalFormat df = new DecimalFormat("0.00");
		double grandTotal = 0.00;
		double theAverage = 0.00;
		
		for (int p = 0; p < totals.length; p++) {
			grandTotal += totals[p];
		}
		
		theAverage = grandTotal / totals.length;
		String theAveragePrint = "Average: " + df.format(theAverage);
		
		return theAveragePrint;
	}
}
