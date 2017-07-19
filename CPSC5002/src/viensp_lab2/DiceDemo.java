package viensp_lab2;
/*
* Phillip Viens
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/
import java.util.Scanner;
public class DiceDemo {
/** 
* @author Phillip Viens
*
*/
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		final int DIE1_SIDES = 6;    // Number of sides for die # 1
		final int DIE2_SIDES = 6;   // Number of sides for die # 2
		final int MAX_ROLLS = 10;     // Number of times to roll
		int computerCount = 0;
		int userCount = 0;
		int tieCount = 0;
		String input;
		char repeat;
		
		// Create two instances of the Die class
		LoadedDie die1 = new LoadedDie(DIE1_SIDES);
		LoadedDie die2 = new LoadedDie(DIE2_SIDES);
		
		//Display the initial state of the dice.
		System.out.println("This is a game of you versus the computer. "
				+ "We will each have one die.\nWe roll our own die and the "
				+ "higher number wins. We roll ten times \nand the one with "
				+ "the higher number of wins is the grand winner.");
		System.out.println();
		System.out.println();
		
		//System.out.println("Initial value of the dice:");
		//System.out.println(die1.getValue() + " " + die2.getValue());
		
		//Roll the dice 10 times. 
		System.out.println("Rolling the dice " + MAX_ROLLS + " times.");
		System.out.println();
		do {
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
			
				if (die1.getValue() > die2.getValue())
				{
					computerCount ++;
				}
				else if (die2.getValue() > die1.getValue())
				{
					userCount ++;
				}
				else
				{
					tieCount ++;
				}
				//Display the values of the dice.
				//System.out.println(die1.getValue() + " " + die2.getValue());
			}
		
			System.out.println("I won " + computerCount + " times!");
			System.out.println("You won " + userCount + " times!");
		
			if (tieCount > 0)
			{
				System.out.println("We also tied " + tieCount + " times!");
			
				computerCount += tieCount;
				userCount += tieCount;
			}
			if ( computerCount > userCount)
			{
				System.out.println("The grand winner is Me!");
			}
			else if (userCount > computerCount)
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
}
