package viensp_lab2;
/*
* Phillip Viens
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/
public class DiceDemo {
/** 
* @author Phillip Viens
*
*/
	public static void main(String[] args)
	{
		final int DIE1_SIDES = 6;    // Number of sides for die # 1
		final int DIE2_SIDES = 12;   // Number of sides for die # 2
		final int MAX_ROLLS = 5;     // Number of times to roll
		
		// Create two instances of the Die class
		LoadedDie die1 = new LoadedDie(DIE1_SIDES);
		LoadedDie die2 = new LoadedDie(DIE2_SIDES);
		
		//Display the initial state of the dice.
		System.out.println("This simulates the rolling of a "
				+ DIE1_SIDES + " sided die and a "
						+ DIE2_SIDES + " sided die.");
		
		System.out.println("Initial value of the dice:");
		System.out.println(die1.getValue() + " " + die2.getValue());
		
		//Roll the dice five times. 
		System.out.println("Rolling the dice " + MAX_ROLLS + " times.");
		
		for (int i = 0; i < MAX_ROLLS; i++)
		{
			//Roll the dice.
			die1.roll();
			die2.roll();
			
			//Display the values of the dice.
			System.out.println(die1.getValue() + " " + die2.getValue());
		}
	}
}
