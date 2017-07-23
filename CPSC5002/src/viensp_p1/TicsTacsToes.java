package viensp_p1;

import java.util.Scanner;

/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
public class TicsTacsToes {
	
	private String[][] gameboardArray;
	private Scanner kbd;
	private boolean flag;
	private int row;
	private int col;
	int MAX;
	/**
	 * The Constructor. Will take in the size of the TicTacToe Board.
	 * have a static game board.
	*/
	 
	
	public TicsTacsToes(Scanner kbd, int MAX) {
		this.kbd = kbd;
		this.MAX = MAX;
		gameboardArray = new String[MAX][MAX];
		gamePlay(kbd, gameboardArray);
	}
	
	public void gamePlay(Scanner kbd, String[][] gameboardArray) {
		int playTurnCounter = 0;
		int MaxPlays = 9;
		String player;
		do {
			displayGameBoard(gameboardArray);
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
			flag = checkForWinner(playTurnCounter, MaxPlays, gameboardArray, player);
			System.out.println("Checks " + flag);
			playTurnCounter ++;
		} while(flag == false);
		System.out.println("Winner has been found");
	}
	
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
	
	public boolean checkForWinner(int playTurnCounter, int MaxPlays, 
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
			else if(checkForNull(playTurnCounter, MaxPlays)) {
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
			//System.out.println("Stage one, player " + player);
			for (int l = 0; l < MAX; l ++){
				if (gameboardArray[l][i] == player) {
					flagCounter ++;	
				}
				//System.out.println("flagCounter = " + flagCounter);
				if (flagCounter == MAX) {
					flag = true;
					//System.out.println("returning " + flagCounter + " " + flag);
					return flag;
				}
				//System.out.println(flag);
			}
		}
		//System.out.println("returning " + flag);
		return flag;
		
			
	}
	
	public boolean checkRows(String[][] gameboardArray, String player) {
		boolean flag = false;
		int flagCounter;
		//System.out.println("Check rows");
		
		for(int i = 0; i < MAX; i++) {
			flagCounter = 0;
			//System.out.println("Stage one, player " + player);
			for (int l = 0; l < MAX; l ++){
				if (gameboardArray[i][l] == player) {
					flagCounter ++;	
				}
				//System.out.println("flagCounter = " + flagCounter);
				if (flagCounter == MAX) {
					flag = true;
					//System.out.println("returning " + flagCounter + " " + flag);
					return flag;
				}
				//System.out.println(flag);
			}
		}
		//System.out.println("returning " + flag);
		return flag;
	}
	
	public boolean checkTopToBottom(String[][] gameboardArray, String player) {
		boolean flag = false;
		int flagCounter = 0;
		int i;
		//System.out.println("Check ttb");
		
		for(i = 0; i < MAX; i++) {
				if (gameboardArray[i][i] == player) {
					flagCounter ++;	
				}
				//System.out.println("flagCounter = " + flagCounter);
				if (flagCounter == MAX) {
					flag = true;
					//System.out.println("returning " + flagCounter + " " + flag);
					return flag;
				}
				//System.out.println(flag);
			}
		//System.out.println("returning " + flag);
		return flag;
		
		}
		
		public boolean checkBottomToTop(String[][] gameboardArray, String player) {
			boolean flag = false;
			int flagCounter = 0;
			int NEWMAX = MAX - 1;
			int i;
			//System.out.println("Checks btt");
			
			for (i = NEWMAX; i >= 0; i--) {
				if (gameboardArray[NEWMAX-i][i] == player) {
					flagCounter ++;
				}
				//System.out.println("flagCounter = " + flagCounter);
				if (flagCounter == MAX) {
					flag = true;
					//System.out.println("returning " + flagCounter + " " + flag);
					return flag;
				}
				System.out.println(flag);
			}
		//System.out.println("returning " + flag);
		return flag;
		}
		
		public boolean checkForNull(int playerTurnCount, int MaxPlays) {
			boolean flag = false;
			//System.out.println("Checks for null");
			
			if(playerTurnCount == (MaxPlays-1)) {
				flag = true;
				return flag;
			}
			return flag;
		}

			
}

