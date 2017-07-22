/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
package viensp_p1;

import java.util.Scanner;

/**
 * 
 * @author Phillip J Viens
 *
 */
public class TicTacToe {
	
	int MAX; 
	String player;
	String[][] playsArray;
	String[][] gameboardArray;
	int col;
	int row;
	Scanner kbd;
	/**
	 * The Constructor. Will take in the size of the TicTacToe Board.
	 */
	public TicTacToe(int SquaresNumber, String Player) {
		//displayGameBoard();
		player = Player;
		gameboardArray = playsArray();
		row = row();
		col = col();
		displayGameBoard(gameboardArray);
		//displayGameBoard(MAX, playsArray);
		//col();
		//playsArray();
		//displayGameBoard(MAX, playsArray);
	}
	
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
	
	public
	int col() {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Which Column? ");
		col = kbd.nextInt();
		kbd.nextLine();
		return col;
		
	}
	public String[][] playsArray() {
		final int MAX = 3;
		String[][] playsArray = new String [MAX][MAX];
		playsArray[row][col] = player;
		
		return playsArray;
	}
	public static void displayGameBoard(String[][] gameboardArray) {
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
		
	public void setMAX(int squaresNumber) {
		MAX = squaresNumber;
	}
	
	public String[][] getArray() {
		return playsArray;
		
	}
	
	//public String setPlayer(String Player) {
	//	player = Player;
	//	return player;
}

