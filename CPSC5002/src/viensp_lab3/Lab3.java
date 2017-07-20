package viensp_lab3;

import java.util.Scanner;

public class Lab3
{

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int INT_LO = 50; //INT_LO(kbd);
		int INT_HI = 75; //INT_HI(kbd);
		GuessGame newInteger = new GuessGame(INT_LO, INT_HI);
		int number = newInteger.getNewInteger();
		guessNumber(kbd, number, INT_LO, INT_HI);
	}
		
		public static void guessNumber(Scanner kbd, int number, 
				int INT_LO, int INT_HI) {
			
			System.out.println(number);
			int guess;
			int guessCounter = 0;
			System.out.print("Guess a number between " 
					+ INT_LO + " and " + INT_HI + ": ");
			
			guess = kbd.nextInt();
			
			while (guess < INT_LO || guess > INT_HI) {
				System.out.println("That's outside the specified range!");
				System.out.print("Guess a number between " 
						+ INT_LO + " and " + INT_HI + ": ");
				
				guess = kbd.nextInt();
				
				
			}
			guessCounter ++;
			
			while(guess != number)
			{
				if(guess > number)
				{
					System.out.println(guess + " is too high");
				}
				else
				{
					System.out.println(guess + " is too low");
				}
				System.out.println();
				System.out.print("Guess a number between " 
						+ INT_LO + " and " + INT_HI + ": ");
				guess = kbd.nextInt();
				kbd.nextLine();
				guessCounter ++;
			}
				
				System.out.println("Thats right!");
				System.out.println("You guessed " + guessCounter + " times!");
			//return guess;
		}
		
	public int INT_LO(Scanner kbd) {
		int lo;
		System.out.println();
		System.out.println("Please enter the lowest number in the range: ");
		lo = kbd.nextInt();
		
		return lo;
		
	}
	public int INT_HI(Scanner kbd) {
		int hi;
		System.out.println();
		System.out.println("Please enter the lowest number in the range: ");
		hi = kbd.nextInt();
		
		return hi;	
	}

}
