package viensp_p1;

import java.util.Scanner;
/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
public class TicsTacsToes {
	public String[][] gameboardArray;
	public Scanner kbd;
	public  int MAX;
	private boolean flag;
	private int row;
	private int col;
	
	/**
	 * The Constructor. Will take in the size of the TicTacToe Board.
	 * 
	*/
	public TicsTacsToes(Scanner kbd, int MAX) {
		this.kbd = kbd;
		this.MAX = MAX;
	}
	
	/**
	 * gamePlay method. Counts the number of turns up to 9 turns switching 
	 * between users each time. Using the CheckForWinner method. 
	 * The board is monitored for winner. 
	 * @param kbd is a scanner that allows user to input the move
	 * @param gameboardArray takes in the array of the gameboard moves
	 */
	public void gamePlay(Scanner kbd, String[][] gameboardArray) {
		int playTurnCounter = 0;
		int MaxNumberOfPlays = 9;
		String player;
		displayGameBoard(gameboardArray);
		do {
			if (playTurnCounter % 2 == 0) {
				player = "X";
			}
			else {
				player = "O";
			}
			System.out.println(player + ", it's your turn.");
			System.out.println("Which Row: ");
			row = kbd.nextInt();
			System.out.println("Which col: ");
			col = kbd.nextInt();
			kbd.nextLine();
			while (gameboardArray[row][col] == "X" 
					|| gameboardArray[row][col] == "O") {
				System.out.println("Space already used... Cheater");
				System.out.print("Which Row: ");
				row = kbd.nextInt();
				System.out.print("Which Column: ");
				col = kbd.nextInt();
				kbd.nextLine();
			}
			gameboardArray[row][col] = player;
			displayGameBoard(gameboardArray);
			flag = checkForWinner(playTurnCounter, MaxNumberOfPlays, 
					gameboardArray, player);
			playTurnCounter ++;
		} while(flag == false);
		System.out.println("Winner has been found");
	}
	
	/**
	 * displays the TicTacToe grid and all moves made within the grid.
	 * @param gameboardArray takes in the Array of moves by each player
	 */
	public void displayGameBoard(String[][] gameboardArray) {
		int i;
		int l;
		System.out.print(" ");
		for (i = 0; i < 3; i++)
		{
			System.out.printf("%4s", i);
		}
		System.out.println();
				
		for(i = 0; i < 3; i++) {
			System.out.print(i + ".|");

			for(l = 0; l < 3; l++) {
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
			for(l = 0; l < 3; l++) {
				System.out.print("----");
			}
			System.out.println();
		}
	}
	
	/**
	 *  
	 * @param playTurnCounter
	 * @param MaxNumberOfPlays
	 * @param gameboardArray
	 * @param player
	 * @return
	 */
	public boolean checkForWinner(int playTurnCounter, int MaxNumberOfPlays, 
			String[][] gameboardArray, String player) {
			if (checkRows(gameboardArray, player)){
				return true;
			}
			else if(checkColumns(gameboardArray, player)) {
				return true;
			}
			else if(checkTopToBottom(gameboardArray, player)) {
				return true;
			}
			else if(checkBottomToTop(gameboardArray, player)) {
				return true;
			}
			else if(checkForNull(playTurnCounter, MaxNumberOfPlays)) {
				return true;
			}
			else {
				return false;
			}
	}
	
	public boolean checkColumns( String[][] gameboardArray, String player) {
		boolean flag = false;
		int flagCounter;
		
		for(int i = 0; i < MAX; i++) {
			flagCounter = 0;
			for (int l = 0; l < MAX; l ++){
				if (gameboardArray[l][i] == player) {
					flagCounter ++;	
				}
				if (flagCounter == MAX) {
					flag = true;
					return flag;
				}
			}
		}
		return flag;
		
			
	}
	
	public boolean checkRows(String[][] gameboardArray, String player) {
		boolean flag = false;
		int flagCounter;
		for(int i = 0; i < MAX; i++) {
			flagCounter = 0;
			for (int l = 0; l < MAX; l ++){
				if (gameboardArray[i][l] == player) {
					flagCounter ++;	
				}
				if (flagCounter == MAX) {
					flag = true;
					return flag;
				}
			}
		}
		return flag;
	}
	
	public boolean checkTopToBottom(String[][] gameboardArray, String player) {
		boolean flag = false;
		int flagCounter = 0;
		int i;
		for(i = 0; i < MAX; i++) {
				if (gameboardArray[i][i] == player) {
					flagCounter ++;	
				}
				if (flagCounter == MAX) {
					flag = true;
					return flag;
				}
			}
		return flag;
		}
		
		public boolean checkBottomToTop(String[][] gameboardArray, String player) {
			boolean flag = false;
			int flagCounter = 0;
			int NEWMAX = MAX - 1;
			int i;
			for (i = NEWMAX; i >= 0; i--) {
				if (gameboardArray[NEWMAX-i][i] == player) {
					flagCounter ++;
				}
				if (flagCounter == MAX) {
					flag = true;
					return flag;
				}
			}
		return flag;
		}
		public boolean checkForNull(int playerTurnCount, int MaxPlays) {
			boolean flag = false;
			
			if(playerTurnCount == (MaxPlays-1)) {
				flag = true;
				return flag;
			}
			return flag;
		}
		
		public void welcomeMessage() {
			System.out.println("Welcome to TicTacToe");
		}
		public void goodbyeMessage() {
			System.out.println();
			System.out.println("Have a good one Sailor.");
			System.out.println();
		}
}

