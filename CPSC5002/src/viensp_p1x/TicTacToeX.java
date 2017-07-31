/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
package viensp_p1x;

import java.util.Scanner;

/**
 * TicTacToe class that has two users input coordinates on a 2D array.
 * Once coordinates are taken in. A a X or an O is placed on the corresponding
 * spot. through a series of methods. The game board is checked for a winner 
 * and displayed after each turn. If a winner has been declared the game ends.
 * If the game reaches the max amount of plays the game also ends. 
 * @author Phillip J Viens
 *
 */
public class TicTacToeX {
	private final int INT_LO = 3;
	private final int INT_HI = 25;
	private Scanner kbd;				//scanner for player input
	private int max;					//max for the size of board
	private String[][] gameboardArray;	//Array for moves
	private int newMax;					//max for checkBottomToTop method.
	private int maxNumberOfPlays;		//holds MAX for checkForNull method
	private int playTurnCounter;		//counts the current play for modulo.
	private int gamePieceCounter;		//counts the presence of player's move
	private String player;				//Holds the string for Xs & Os
	private int row;					//holds the row var for player move.
	private int col;					//holds the col var for player move.
	private String player1;				//holds the String for player1
	private String player2;				//holds the String for player2
	
	/**
	 * In the constructor I've declared the size of the board, the Scanner,
	 * the variables for both player1 and player2
	 * 
	*/
	public TicTacToeX(Scanner kbd, String player1, String player2) {
		

		
		this.kbd = kbd;				//creates new variable for Scanner
		this.player1 = player1;		//creates new variable for player1
		this.player2 = player2;		//creates new variable for player2
		
		//declares the gameboardArray
		this.gameboardArray = new String[max][max];
	}
	
	/**
	 * gamePlay method. Counts the number of turns up to 9 turns switching 
	 * between users each time. Using the CheckForWinner method. 
	 * The board is monitored for winner. 
	 * @param kbd is a scanner that allows user to input the move
	 */
	public void gamePlay() {
		playTurnCounter = 0;
		max = setMax();		//creates a variable for max
		maxNumberOfPlays = (max*max);
		
		//creates new Array for every new game.
		this.gameboardArray = new String[max][max];
		displayGameBoard();
		
		//do/while that repeats as long as flag == false.
		do {
			//checks to see who's turn it is.
			if (playTurnCounter % 2 == 0) {
				player = this.player1;
			}
			else {
				player = this.player2;
			}
			System.out.println(player + ", it's your turn.");
			
			//Has use input row and column they'd like to make a move in.
			//Checks to ensure it's within bounds.
			System.out.print("Which Row: ");
			row = this.kbd.nextInt();
			checkRowBounds();
			System.out.print("Which Column: ");
			col = this.kbd.nextInt();
			checkColumnBounds();
			this.kbd.nextLine();
			
			//Checks to see if space has already been played.
			checkForOverlap();
			
			//places the players move
			this.gameboardArray[row][col] = player;
			
			//shows updated gameboard
			displayGameBoard();
			
			//checks to see if winner has been found
			//or if any space is null
			playTurnCounter ++;
		} while(checkForWinner() == false);
	}
	
	/**
	 * displays the TicTacToe grid and all moves made within the grid
	 */
	public void displayGameBoard() {
		int i;	//variables for loops
		int l;	//variables for loops
		
		System.out.println();
		System.out.print(" ");
		
		// prints the column number
		for (i = 0; i < max; i++)
		{
			System.out.printf("%4s", i);
		}
		System.out.println();
		
		// prints the row numbers
		for(i = 0; i < max; i++) {
			System.out.print(i + ".|");

			// prints the rows including spaces and gameboardArray.
			for(l = 0; l < max; l++) {
				
				//checks to see if any spaces are null.
				if (this.gameboardArray[i][l] == null)
				{
					System.out.print("   |");
				}
				else
				{
				System.out.print(" " + this.gameboardArray[i][l] + " |");
				}
			}
			System.out.println();
			System.out.print("  -");
			for(l = 0; l < max; l++) {
				System.out.print("----");
			}
			System.out.println();
		}
	}
	
	/**
	 *  Method that passes variables to other check methods. This determines 
	 *  if a winner has been found after each turn.
	 * @return boolean true/false
	 */
	public boolean checkForWinner() {
		
		//calls checkRows method returns boolean.
		if (checkRows()){
			winnerMessage();
			return true;
		}
		
		//calls checkColumns method returns boolean
		else if(checkColumns()) {
			winnerMessage();
			return true;
		}
			
		//calls check diagonal TopToBottom method returns boolean.
		else if(checkTopToBottom()) {
			winnerMessage();
			return true;
		}
			
		//calls check diagonal bottomToTop method returns boolean.
		else if(checkBottomToTop()) {
			winnerMessage();
			return true;
		}
			
		//calls checkForNull method and returns boolean
		else if(checkForMaxMoves()) {
			catMessage();
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * boolean method that checks columns for a winner by summing a counter
	 * If the counter equals the MAX number of columns. A winner is declared
	 * @param gameboardArray takes in the gameboardArray to check it.
	 * @param player Checks for the string of the player for it's presence.
	 * @return boolean true/false
	 */
	public boolean checkColumns() {
		for(int i = 0; i < max; i++) {
			 gamePieceCounter = 0;
			
			//For loops that check through columns and rows.
			for (int l = 0; l < max; l ++){
				if (this.gameboardArray[l][i] == player) {
					gamePieceCounter ++;	
				}
				if (gamePieceCounter == max) {
					return true;
				}
			}
		}		
		return false;	
	}
	
	/**
	 * boolean method that checks rows for a winner by summing a counter
	 * If the counter equals the MAX number of rows. A winner is declared
	 * @param gameboardArray takes in the gameboardArray to check it.
	 * @param player Checks for the string of the player for it's presence.
	 * @return boolean true/false
	 */
	private boolean checkRows() {
		//for loops that check through columns and rows.
		for(int i = 0; i < max; i++) {
			gamePieceCounter = 0;
			for (int l = 0; l < max; l ++){
				if (this.gameboardArray[i][l] == player) {
					gamePieceCounter ++;	
				}
				if (gamePieceCounter == max) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * boolean method that checks diagonal from 0,0 to 2,2 for a winner 
	 * by summing a counter. If the counter equals the MAX number of the 
	 * diagonal. A winner is declared.
	 * @param gameboardArray takes in the gameboardArray to check it.
	 * @param player Checks for the string of the player for it's presence.
	 * @return boolean true/false
	 */
	private boolean checkTopToBottom() {
		gamePieceCounter = 0;
		for(int i = 0; i < max; i++) {
				if (this.gameboardArray[i][i] == player) {
					gamePieceCounter ++;	
				}
				if (gamePieceCounter == max) {
					return true;
				}
			}
		return false;
		}
		
	/**
	 * boolean method that checks diagonal from 2,0 to 0,2 for a winner 
	 * by summing a counter. If the counter equals the MAX number of the 
	 * diagonal. A winner is declared.
	 * @param gameboardArray takes in the gameboardArray to check it.
	 * @param player Checks for the string of the player for it's presence.
	 * @return boolean true/false
	 */
	private boolean checkBottomToTop() {
		gamePieceCounter = 0;
		newMax = max - 1;
		for (int i = newMax; i >= 0; i--) {
			if (this.gameboardArray[newMax-i][i] == player) {
				gamePieceCounter ++;
			}
			if (gamePieceCounter == max) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * boolean method that counts number of plays against MAxNumberOfPlays.
	 * If the board is full. It returns a false variable and ends the game.
	 * @return boolean true/false
	 */
	private boolean checkForMaxMoves() {
			return playTurnCounter == (maxNumberOfPlays);
		}
		
	/**
	 * method that is called if a winner has been found.
	 */
	public void winnerMessage() {
		System.out.println();
		System.out.println("Congratulations " + player + " won!");
	}
	
	/**
	 * method that is called if the board is full and no winner is found.
	 */
	public void catMessage() {
		System.out.println();
		System.out.println("I'm sorry to say it, but "
				+ "nobody won this round... ");
	}
	
	/**
	 * Checks the row value to make sure its within the array
	 */
	public void checkRowBounds() {
		while (row >= max || row < 0) {
			System.out.println("Row out of bounds");
			System.out.print("Which Row: ");
			row = this.kbd.nextInt();
		}
	}
	
	/**
	 * Checks the col value to make sure its within the array
	 */
	public void checkColumnBounds() {
		while (col >= max || col < 0) {
			System.out.println("Column out of bounds");
			System.out.print("Which Column: ");
			col = this.kbd.nextInt();
		}
	}
	
	/**
	 *  Checks to see if gameboard[row][col] has a play on it
	 *  already. Has the user repeat if there is.
	 */
	public void checkForOverlap() {
		while (this.gameboardArray[row][col] == "X" 
				|| this.gameboardArray[row][col] == "O") {
			System.out.println("Space already used... Cheater");
			System.out.print("Which Row: ");
			row = this.kbd.nextInt();
			checkRowBounds();
			System.out.print("Which Column: ");
			col = this.kbd.nextInt();
			checkColumnBounds();
			this.kbd.nextLine();
		}
	}
	
	/**
	 * Has the user input a variable and sets it as a max.
	 * Using check range method checks for specified parameters.
	 * @return the max set.
	 */
	public int setMax() {
		
		System.out.println("Please input the maximum amout of colums and "
				+ "rows. \nThe minumum number of rows needs to be 3 and "
				+ "\nthe maximum number of rows is 25. The game will only"
				+ "\n work with odd numbers.");
		System.out.print("Please input Max rows/cols (Odd nums only): ");
		max = kbd.nextInt();
		checkRange();
		
		return max;
	}
	
	/**
	 * checks to see if the number entered is odd and between the range specified.
	 * if not user is asked to repeat.
	 */
	public void checkRange(){
		while (max < INT_LO || max > INT_HI || (max % 2 == 0)) {
			System.out.println("Needs to be between 3 and 25");
			System.out.print("Please input Max rows/cols (Odd nums only): ");
			max = kbd.nextInt();
		}
	}
}


