package viensp_lab2;
/*
* Phillip Viens
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/

import java.util.Random;

/**
 * 
 * @author Phillip J Viens
 *
 */
public class LoadedDie {
	private int sides;   //Number of sides
	private int value;   //The die's value
	
	/**
	 * The constructor performs an initial roll of the die.
	 * @param loadedNumber        which number should come up more often
	 * @param moreTimesPerHundred how many times per 100 rolls to come up with 
	 *                            the loaded number (instead of uniform random)
	 */
	
	public LoadedDie(int numSides)
	{
		sides = numSides;
		roll();
	}
	
	/** 
	 * The roll method simulates the rolling of
	 * the die
	 * @param args
	 */
	
	public void roll()
	{
		//Create a Random object.
		Random rand = new Random();
		
		//Get a random value for the die.
		value = rand.nextInt(sides) + 1;
		
	}
	
	/**
	 * getSides method
	 * @ return The number of sides for this die.
	 */
	
	public int getSides()
	{
		return sides;
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