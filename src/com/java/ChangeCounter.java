package com.java;

import java.util.Scanner;

/**
 * @author Anthony Zenin - ID: 991508379
 * @author Kirtan Parekh - ID: 991551563
 * Title: ICE 3 - Change Maker - SYST 38634 ICE03
 * Date: February 5th, 2021
 * 
 * Description: A program that counts the change (in coins) for a given number of cents.
 */
public class ChangeCounter {

	private static final int QUARTER = 25;
	private static final int DIME = 10;
	private static final int NICKEL = 5;

	public static void main(String[] args) throws BadChangeException {
		int input = getInput();
		int[] change = makeChange(input);
		
		String quarterStr = "";
		String dimeStr = "";
		String nickelStr = "";
		
		if (change[0] != 0) {
			quarterStr = change[0] + " quarter(s) ";
		}
		
		if (change[1] != 0) {
			dimeStr = change[1] + " dime(s) ";
		}
		
		if (change[2] != 0) {
			nickelStr = change[2] + " nickel(s) ";
		}
		System.out.println(input + " cents requires " + quarterStr + dimeStr + nickelStr);
	}

	private static int getInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter amount in cents between 0 and 100: ");
		int input = sc.nextInt();
		return input;
	}
	
	public static int[] makeChange(int input) throws BadChangeException {
		// Checking if the input is within range
		if (input < 0 || input > 100) {
			throw new BadChangeException("Change out of bounds.");
		}
		int numberOfQuarters = 0;
		int numberOfDimes = 0;
		int numberOfNickels = 0;
		
		int[] change = {0, 0, 0};
		
		// Performing actions to determine amount of change
		numberOfQuarters = input / QUARTER;
		input = input % QUARTER;
		
		numberOfDimes = input / DIME;
		input = input % DIME;
		
		numberOfNickels = input / NICKEL;
		input = input % NICKEL;
		
		// Checking input and if non zero, then round either up or down
		if (input == 0) {
			change[0] = numberOfQuarters;
			change[1] = numberOfDimes;
			change[2] = numberOfNickels;
			return change;
		} else {
			// Rounding done here
			if (input >= 3) {
				input = (int) Math.ceil(input / 100);
				numberOfNickels += 1;
			} else {
				input = (int) Math.floor(input / 100);
			}
			// Returning data
			change[0] = numberOfQuarters;
			change[1] = numberOfDimes;
			change[2] = numberOfNickels;
			return change;
		}
	}
}
