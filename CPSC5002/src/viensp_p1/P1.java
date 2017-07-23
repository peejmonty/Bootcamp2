package viensp_p1;

import java.util.Scanner;
public class P1 {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int MAX = 3;
		//String[] players = players();
		System.out.println("Beginning");
		TicsTacsToes game = new TicsTacsToes(kbd, MAX);
		//TicTacToe.displayGameBoard(MAX, playsArray);
		//row = playerX.row();
		//row = playerO.row();
		//TicTacToe.displayGameBoard();
		
	}
		/*
		public static String[] players() {
			final int MAX = 2;
			String[] players = new String[MAX];
			
			players[0] = "X";
			players[1] = "O";
			
			return players;
			*/
}
		
		


