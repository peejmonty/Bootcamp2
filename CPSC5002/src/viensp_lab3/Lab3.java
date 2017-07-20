package viensp_lab3;

import java.util.Scanner;

public class Lab3
{

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int INT_LO = 50; //INT_LO(kbd);
		int INT_HI = 75; //INT_HI(kbd);
		GuessGame newInteger = new GuessGame(INT_LO, INT_HI);
		int number = newInteger.getValue();
	}
		
		public static int guessNumber(Scanner kbd, int number) {
			
			int guess;
			int guessCounter = 0;
			System.out.println("Please enter a guess: ");
			guess = kbd.nextInt();
			guessCounter ++;
			
			while(guess != number)
			{
				if(guess > number)
				{
					System.out.println("Sorry that guess was too high");
					System.out.print("Guess Again: ");
				}
				else
				{
					System.out.println("Sorry that guess was too low");
					System.out.print("Guess Again: ");
				}
				guess = kbd.nextInt();
				guessCounter ++;
		
			}
			return guess;
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
