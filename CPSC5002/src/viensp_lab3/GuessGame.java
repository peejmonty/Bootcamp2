package viensp_lab3;

import java.util.Random;

public class GuessGame {
	private int loRange;
	private int hiRange;
	private int newInteger;
	
	public GuessGame (int INT_LO, int INT_HI) {
		
		loRange = INT_LO + 1;
		hiRange = INT_HI + 1;
		newNumber();
	}
	
	public void newNumber() {
		//Creates a random object
		Random rand = new Random();
		
		newInteger = rand.nextInt(hiRange- loRange) + loRange;
	}
	
	public int getNewInteger() {
		
		return newInteger;
	}
	

}
