/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
package viensp_p1;

import java.util.Scanner;

/**
 * Create a TicTacToe Board
 * Have users take turns placing X's and O's
 * Check for a winner.
 * @author Phillip J Viens
 *
 */
 public class TicTacToe {

	String X;
	String O;
	int row;
	int col;
	String[][] gameboardArray;
	String[] XsOs;
	Scanner kbd;
	
	/**
	 * The Constructor. Will take in the size of the TicTacToe Board.
	 * have a static game board.
	*/
	 
	
	public TicTacToe(String[] players) {
		final int MAX = 3;
		XsOs = players;
		//X = playerX;
		//O = playerO;
		String[][] gameboardArray = new String[MAX][MAX];
		Scanner kbd = new Scanner(System.in);
		
		play(kbd, gameboardArray, XsOs);
		
	}
	
	public String[][] play(Scanner kbd, String[][] gameboardArray, String[] XsOs) {
		
		for (int i = 0; i < XsOs.length; i++)
		{
			System.out.println(XsOs[i] + ", it's your turn.");
			System.out.print("Which Row: ");
			row = kbd.nextInt();
		
			System.out.print("Which Column: ");
			col = kbd.nextInt();
			kbd.nextLine();
			//gameboardArray[row][col] = XsOs[i];
			
			while (gameboardArray[row][col] == "X" || gameboardArray[row][col] == "O") {
				
				System.out.println("Space already used... Cheater");
				System.out.print("Which Row: ");
				row = kbd.nextInt();
			
				System.out.print("Which Column: ");
				col = kbd.nextInt();
				kbd.nextLine();
				//gameboardArray[row][col] = XsOs[i];
			}
			gameboardArray[row][col] = XsOs[i];

			displayGameBoard(gameboardArray);
		}
		return gameboardArray;
		
	}
	/*
	public String[][] playerO(Scanner kbd, String[][] gameboardArray) {
		
		System.out.println("O, it's your turn.");
		System.out.print("Which Row: ");
		row = kbd.nextInt();
		
		System.out.print("Which Column: ");
		col = kbd.nextInt();
		kbd.nextLine();
		
		
		gameboardArray[row][col] = O;
		
		return gameboardArray;
	}
	*/
	
	public void displayGameBoard(String[][] gameBoardArray) {
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
				if (gameBoardArray[i][l] == null)
				{
					System.out.print("   |");
				}
				else
				{
				System.out.print(" " + gameBoardArray[i][l] + " |");
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
 }
	
		/*
		//displayGameBoard();
		player = Player;
		row = row();
		col = col();
		playsArray = playsArray();
		//gameboardArray = gameboardArray(player, row, col);
		
		displayGameBoard(gameboardArray);
		//displayGameBoard(MAX, playsArray);
		//col();
		//playsArray();
		//displayGameBoard(MAX, playsArray);
	}
	/**
	 * Takes in a users input for the row they'd like to place their turn
	 * @return row variable to place the game piece.
	 */
	 /*
	public int row(){
		
		Scanner kbd = new Scanner(System.in);
		System.out.println();
		//displayGameBoard();
		System.out.println();
		System.out.println(player + ", it is your turn");
		System.out.println("Which Row? ");
		row = kbd.nextInt();
		kbd.nextLine();
		
		return row;
		
		
	}
	
	/**
	 * Takes in a users input for the column they'd like to place their turn
	 * @return col variable to place the game piece
	 */
	 /*
	public int col() {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Which Column? ");
		col = kbd.nextInt();
		kbd.nextLine();
		return col;
		
	}
	
	/**
	 * This is an array method that takes in the player
	 * as well as the column and row they'd like to place
	 * @return the player's array for their own piece.
	 */
	 
	 /*
	public String[][] playsArray() {
		row = row();
		col = col();
		final int MAX = 3;
		String[][] playsArray = new String [MAX][MAX];
		playsArray[row][col] = player;
		
		return playsArray;
	}
	
	/**
	 * a static array that takes in the the player as well as the column and row. 
	 * @param playsArray returns a static 
	 * game board array that contains both players
	 * @return
	 */
	 /*
	public static String[][] gameboardArray(String player, int row, int col) {
		final int MAX = 3;
		String[][] gameboardArray = new String[MAX][MAX];
		
		gameboardArray[row][col] = player;
		
		return gameboardArray;
	}
	
	/**
	 * Method that displays the game board
	 * @param gameboardArray
	 */
	 /*
	
	/**
	 * intakes the Max from P1. and sets it in the constructos
	 * @param squaresNumber as final int MAX
	 */
	 
	 /*
	public void setMAX(int squaresNumber) {
		MAX = squaresNumber;
	}
	
	/**
	 * Gets the player array and sends and returns it.
	 * @return
	 */
	/*
	public String[][] getArray() {
		return playsArray;
		
	}
	
	//public String setPlayer(String Player) {
	//	player = Player;
	//	return player;
	 */

