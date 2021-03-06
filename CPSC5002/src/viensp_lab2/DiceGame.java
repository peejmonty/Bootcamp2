package viensp_lab2;
/*
* Phillip Viens
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/
import java.util.Scanner;

public class DiceGame {

/** 
* Lab2 DiceGame
* purpose: Using the LoadedDie class write a game that has the user play against the computer. 
* @author Phillip Viens
*/
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);  //Scanner for user to roll. 
		welcome();
		letsPlay(kbd);
		goodbye();
		kbd.close();   //closes the scanner
	}
	
	/**
	 * method that has user roll dice against the computer. Using the LOADED 
	 * variables.  Dice land on the Variable at the specified 
	 * MORE_THAN variable out of 100 times.
	 * @param kbd   takes in the scanner. 
	 */
	public static void letsPlay(Scanner kbd) {
		final int LOADED1 = 6;    //Weighted side for die # 1
		final int LOADED2 = 1;    //Weighted side for die # 2 
		final int MORE_THAN = 30;   //Initializes 30 times out of 100 rule
		final int MAX_ROLLS = 10;   // Number of times to roll
		String input;   //initializes String input for Do/While
		char repeat;
	
		// Create two instances of the Die class
		LoadedDie die1 = new LoadedDie(LOADED1, MORE_THAN);
		LoadedDie die2 = new LoadedDie(LOADED2, MORE_THAN);
	
		//Roll the dice 10 times. 
		System.out.println("Rolling the dice " + MAX_ROLLS + " times.");
		System.out.println();
	
		//Repeats while user specifies to
		do {
			int computerWinCount = 0;
			int userWinCount = 0;
			int tieCount = 0;
			for (int i = 0; i < MAX_ROLLS; i++)
			{
				//Roll the dice.
				System.out.println("Roll " + (i+1) + " of 10");
				die1.roll();
				System.out.println("I rolled a " + die1.getValue());
				System.out.print("Ready to roll? (Press ENTER when ready)");
				kbd.nextLine();
				die2.roll();
				System.out.println("You rolled a " + die2.getValue());
				System.out.println();
		
				//Checks to see whether the user or computer won
				//Then tallies the results.
				if (die1.getValue() > die2.getValue())
				{
					computerWinCount ++;
				}
				else if (die2.getValue() > die1.getValue())
				{
					userWinCount ++;
				}
				else
				{
					tieCount ++;
				}
			}
			System.out.println("I won " + computerWinCount + " time(s)!");
			System.out.println("You won " + userWinCount + " time(s)!");
		
			//Checks to see if there was a tie at all. 
			if (tieCount > 0)
			{
				System.out.println("We also tied " + tieCount + " time(s)!");
				computerWinCount += tieCount;
				userWinCount += tieCount;
			}
			if ( computerWinCount > userWinCount)
			{
				System.out.println("The grand winner is Me!");
			}
			else if (userWinCount > computerWinCount)
			{
				System.out.println("The grand winner is You!");
			}
			else
			{
				System.out.println("Looks like we tied!");
			}
			System.out.println();
			System.out.println("Play again (y/n)? ");
			input = kbd.nextLine();
			repeat = input.charAt(0);
		} while (repeat == 'y' || repeat == 'Y');
	}
	
	/**
	 * welcome method that displays a welcome message explaining the game.
	 */
	public static void welcome() {
		//Display the initial state of the dice.
		System.out.println();
		System.out.println("This is a game of you versus the computer. "
				+ "We will each have one die.\nWe roll our own die and the "
				+ "higher number wins. We roll ten times \nand the one with "
				+ "the higher number of wins is the grand winner.");
		System.out.println();
		System.out.println();
	}
	
	/**
	 * goodbye method that prints a goodbye message completing the program 
	 */
	public static void goodbye() {
		
		System.out.println();
		System.out.println("Thanks for playing have a great day!");
		System.out.println();
	}
}
