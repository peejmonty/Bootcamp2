package viensp_p1;
/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
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
			
			//String to hold repeat variable
			String input;
			char repeat;
			
			//Creates an array to hold player's moves.
			int MAX = 3;
			String[][] gameboardArray = new String[MAX][MAX];
			
			//creates an object to call TicTacToe class
			TicTacToe game = new TicTacToe(kbd, MAX);
			
			//calls welcome message from game instance.
			game.welcomeMessage();
			
			// do/while that plays TicTacToe as many times as desired. 
			do{
				//Calls gamePlay method in TicTacToe class
				game.gamePlay(kbd, gameboardArray);	
				
				//Asks user to repeat game
				System.out.print("Repeat Game? (y/n): ");
				input = kbd.nextLine();
				repeat = input.charAt(0);
			} while (repeat == 'y' || repeat == 'Y');
			
			//calls welcome message from game instance.
			game.goodbyeMessage();
			kbd.close();	//closes the Scanner.
		}			
}
