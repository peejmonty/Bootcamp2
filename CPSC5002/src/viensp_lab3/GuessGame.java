package viensp_lab3;

import java.util.Random;

public class GuessGame {
	private int loRange;
	private int hiRange;
	private int newInteger;
	
	public GuessGame (int INT_LO, int INT_HI) {
		
		loRange = INT_LO;
		hiRange = INT_HI;
		newNumber();
	}
	
	public void newNumber() {
		//Creates a random object
		Random rand = new Random();
		
		newInteger = rand.nextInt((hiRange*2) +1) - loRange;
	}
	
	public int getNewInteger() {
		
		return newInteger;
	}
	

}
