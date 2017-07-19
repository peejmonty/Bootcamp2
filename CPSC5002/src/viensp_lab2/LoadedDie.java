package viensp_lab2;
/*
* Phillip Viens
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/

import java.util.Random;
import java.util.Scannerjj;

/**
 * 
 * @author Phillip J Viens testing testing 
 *
 */
public class LoadedDie {
	private int sides;   //Number of sides
	private int value;   //The die's calue
	
	/**
	 * The constructor performs an initial roll of the die.
	 * @param loadedNumber        which number should come up more often
	 * @param moreTimesPerHundred how many times per 100 rolls to come up with 
	 *                            the loaded number (instead of uniform random)
	 */
	
	public Die(int numSides)
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
	 * @return The valuie of the die.
	 */
	
	public int getValue()
	{
		return value;
	}
}