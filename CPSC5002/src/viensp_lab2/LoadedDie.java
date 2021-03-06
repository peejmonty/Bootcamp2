package viensp_lab2;
/*
* Phillip Viens
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/
import java.util.Random;

/**
 * Lab2 DiceGame
 * purpose: Create a Dice roll game between the user and the computer.
 * The only catch is the 
 * dice are weighted. 30% of the time the computer
 * will always roll a six, and 30% of the time the user will always roll a 1.
* @author Phillip Viens
 */
public class LoadedDie {
	private int loaded;   //Number of sides
	private int moreTimes;
	private int value;   //The die's value
	private int tempValue;
	
	/**
	 * The constructor performs an initial roll of the die.
	 * @param loadedNumber        which number should come up more often
	 * @param moreTimesPerHundred how many times per 100 rolls to come up with 
	 *                            the loaded number (instead of uniform random)
	 */
	public LoadedDie(int loadedNumber, int moreTimesPerHundred)
	{
		loaded = loadedNumber;
		moreTimes = moreTimesPerHundred;
		roll();
	}
	
	 /**
	 * The roll method simulates the rolling of the die.
	 * It will typically set this die's value to a random value
	 * with uniform distribution between 1 and 6. Occasionally,
	 * it will a priori return the favored value (with frequency
	 * determined by the moreTimesPerHundred argument that was passed
	 * to the constructor).
	 * @return value 
	 */
	public void roll()
	{
		//Create a Random object.
		Random rand = new Random();
		
		
		//Get a random value for the die.
		tempValue = rand.nextInt(100) + 1;
		
		//checks to see if tempValue is less than or equalTo
		//the moreTimesPerHundred variable
		if (tempValue <= moreTimes)
		{
			value = loaded;
		}
		else
		{
			
			value = rand.nextInt(7);
		}
		
	}
	
	
	/**
	 * getValue method
	 * @return The value of the die.
	 */
	public int getValue()
	{
		return value;
	}
}