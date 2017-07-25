/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
package viensp_p1;

import java.util.Scanner;
/**
 * This is a class that calls the class TicTacToe. 
 * Using instance fields in that class it plays the game.
 * @author Phillip J Viens
 *
 */
public class P1 {

		/**
		 * main method that sets variables for TicTacToe class. 
		 * @param args
		 */
		public static void main(String[] args) {
			
			//Creates scanner for user input
			Scanner kbd = new Scanner(System.in);
			
			//Creates an array to hold player's moves.
			int MAX = 3;
			String player1 = "X";
			String player2 = "O";
			
			
			//creates an object to call TicTacToe class
			TicTacToe game = new TicTacToe(kbd, MAX, player1, player2);
			
			welcomeMessage();
			play(MAX, kbd, game);
			goodbyeMessage();
		}
		
		/**
		 * 
		 */
		public static void welcomeMessage() {
			System.out.println("Welcome to TicTacToe");
			System.out.println("Each user will have a turn to place their piece by "
					+ "saying where in the board they'd like to place.");
			System.out.println();
		}
		
		/**
		 * 
		 */
		public static void goodbyeMessage() {
			System.out.println();
			System.out.println("Have a good one Sailor!");
			System.out.println();
		}
		
		public static void play(int MAX, Scanner kbd, TicTacToe game) {
			
			//String to hold repeat variable
			String input;
			char repeat;
			
			// do/while that plays TicTacToe as many times as desired. 
			do{
				//Calls gamePlay method in TicTacToe class
				game.gamePlay();	
				
				//Asks user to repeat game
				System.out.print("Repeat Game? (y/n): ");
				input = kbd.nextLine();
				repeat = input.charAt(0);
			} while (repeat == 'y' || repeat == 'Y');
			kbd.close();	//closes the Scanner.
		}			
}
