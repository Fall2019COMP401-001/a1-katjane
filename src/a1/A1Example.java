package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Example {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		int thisNum = scan.nextInt();
		int min = thisNum;
		int max = thisNum;
		int totalSum = 0;
		int numOfNum = 0;
		
		while (scan.hasNext()) {
			thisNum = scan.nextInt();
			totalSum = totalSum + thisNum;
			numOfNum = numOfNum + 1; 
			if (min > thisNum) {
				min = thisNum;
			}
			if (max < thisNum) {
				max = thisNum;
			}
		}
		
		String averageSum = df.format(totalSum / numOfNum);
		
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		System.out.println("Average: " + averageSum);
	}

}
