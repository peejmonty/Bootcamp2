package viensp_p1;
/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
import java.util.Scanner;

/**
 * 
 * @author Phillip J Viens
 *
 */
public class TicTacToe {
	public String[][] gameboardArray;
	public Scanner kbd;				//holds the Scanner
	public  int MAX;				//hold the MAX number of rows & cols.
	private int NEWMAX;				//holds MAX for checkBottomToTop method.
	private int MaxNumberOfPlays;	//holds MAX for checkForNull method
	private int playTurnCounter;	//counts the current play for modulo.
	private String player;			//Holds the string for Xs & Os.
	private boolean flag;			//holds the boolean var for do/while
	private int row;				//holds the row variable for player move.
	private int col;				//holds the col variable for player move.
	
	/**
	 * The Constructor. Will take in the size of the TicTacToe Board.
	 * 
	*/
	public TicTacToe(Scanner kbd, int MAX) {
		this.kbd = kbd;		//creates new variable rules out shadowing.
		this.MAX = MAX;		//creates new variable rules out shadowing.
	}
	
	/**
	 * gamePlay method. Counts the number of turns up to 9 turns switching 
	 * between users each time. Using the CheckForWinner method. 
	 * The board is monitored for winner. 
	 * @param kbd is a scanner that allows user to input the move
	 * @param gameboardArray takes in the array of the gameboard moves
	 */
	public void gamePlay(Scanner kbd, String[][] gameboardArray) {
		playTurnCounter = 0;
		MaxNumberOfPlays = (MAX*MAX);
		
		//creates new Array for every new game.
		gameboardArray = new String[MAX][MAX];
		System.out.println();
		displayGameBoard(gameboardArray);
		
		//do/while that repeats as long as flag == false.
		do {
			//checks to see who's turn it is.
			if (playTurnCounter % 2 == 0) {
				player = "X";
			}
			else {
				player = "O";
			}
			System.out.println(player + ", it's your turn.");
			
			//Has use input row and column they'd like to make a move in.
			System.out.print("Which Row: ");
			row = kbd.nextInt();
			System.out.print("Which col: ");
			col = kbd.nextInt();
			kbd.nextLine();
			
			//Checks to see if space has already been played.
			//repeats if it's not null.
			while (gameboardArray[row][col] == "X" 
					|| gameboardArray[row][col] == "O") {
				System.out.println("Space already used... Cheater");
				System.out.print("Which Row: ");
				row = kbd.nextInt();
				System.out.print("Which Column: ");
				col = kbd.nextInt();
				kbd.nextLine();
			}
			
			//sets player's move
			gameboardArray[row][col] = player;
			System.out.println();
			
			//shows updated gameboard
			displayGameBoard(gameboardArray);
			
			//checks to see if winner has been found
			//or if any space is null
			flag = checkForWinner(playTurnCounter, MaxNumberOfPlays, 
					gameboardArray, player);
			playTurnCounter ++;
		} while(flag == false);
	}
	
	/**
	 * displays the TicTacToe grid and all moves made within the grid.
	 * @param gameboardArray takes in the Array of moves by each player
	 */
	public void displayGameBoard(String[][] gameboardArray) {
		int i;	//variables for loops
		int l;	//variables for loops
		System.out.print(" ");
		
		// prints the column number
		for (i = 0; i < MAX; i++)
		{
			System.out.printf("%4s", i);
		}
		System.out.println();
		
		// prints the row numbers
		for(i = 0; i < MAX; i++) {
			System.out.print(i + ".|");

			// prints the rows including spaces and gameboardArray.
			for(l = 0; l < MAX; l++) {
				
				//checks to see if any spaces are null.
				if (gameboardArray[i][l] == null)
				{
					System.out.print("   |");
				}
				else
				{
				System.out.print(" " + gameboardArray[i][l] + " |");
				}
			}
			System.out.println();
			System.out.print("  -");
			for(l = 0; l < MAX; l++) {
				System.out.print("----");
			}
			System.out.println();
		}
	}
	
	/**
	 *  Method that passes variables to other check methods. This determines 
	 *  if a winner has been found after each turn.
	 * @param playTurnCounter  Counter variable that is passed to checkForNull
	 * @param MaxNumberOfPlays 
	 * @param gameboardArray
	 * @param player
	 * @return boolean true/false
	 */
	public boolean checkForWinner(int playTurnCounter, int MaxNumberOfPlays, 
			String[][] gameboardArray, String player) {
		
			//calls checkRows method returns boolean.
			if (checkRows(gameboardArray, player)){
				winnerMessage();
				return true;
			}
			
			//calls checkColumns method returns boolean
			else if(checkColumns(gameboardArray, player)) {
				winnerMessage();
				return true;
			}
			
			//calls check diagonal TopToBottom method returns boolean.
			else if(checkTopToBottom(gameboardArray, player)) {
				winnerMessage();
				return true;
			}
			
			//calls check diagonal bottomToTop method returns boolean.
			else if(checkBottomToTop(gameboardArray, player)) {
				winnerMessage();
				return true;
			}
			
			//calls checkForNull method and returns boolean
			else if(checkForNull()) {
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
	public boolean checkColumns( String[][] gameboardArray, String player) {
		int flagCounter;
		for(int i = 0; i < MAX; i++) {
			flagCounter = 0;
			
			//For loops that check through columns and rows.
			for (int l = 0; l < MAX; l ++){
				if (gameboardArray[l][i] == player) {
					flagCounter ++;	
				}
				if (flagCounter == MAX) {
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
	public boolean checkRows(String[][] gameboardArray, String player) {
		int flagCounter = 0;
		
		//for loops that check through columns and rows.
		for(int i = 0; i < MAX; i++) {
			flagCounter = 0;
			for (int l = 0; l < MAX; l ++){
				if (gameboardArray[i][l] == player) {
					flagCounter ++;	
				}
				if (flagCounter == MAX) {
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
	public boolean checkTopToBottom(String[][] gameboardArray, String player) {
		int flagCounter = 0;
		int i;
		for(i = 0; i < MAX; i++) {
				if (gameboardArray[i][i] == player) {
					flagCounter ++;	
				}
				if (flagCounter == MAX) {
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
	public boolean checkBottomToTop(String[][] gameboardArray, String player) {
		int flagCounter = 0;
		NEWMAX = MAX - 1;
		int i;
		for (i = NEWMAX; i >= 0; i--) {
			if (gameboardArray[NEWMAX-i][i] == player) {
				flagCounter ++;
			}
			if (flagCounter == MAX) {
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
	public boolean checkForNull() {
		
			//Checks to see if maxNumber of plays has been met.
			if(playTurnCounter == (MaxNumberOfPlays-1)) {
				return true;
			}
			return false;
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
	 * Welcome message that is displayed at the beginning of the game.
	 */
	public void welcomeMessage() {
		System.out.println("Welcome to TicTacToe");
	}
	/**
	 * Goodbye message that is displayed if game is not repeated.
	 */
	public void goodbyeMessage() {
		System.out.println();
		System.out.println("Have a good one Sailor.");
		System.out.println();
	}
}

