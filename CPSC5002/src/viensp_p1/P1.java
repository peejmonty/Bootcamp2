package viensp_p1;

import java.util.Scanner;
public class P1 {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int MAX = 3;
		String input;
		char repeat;
		String[][] gameboardArray = new String[MAX][MAX];
		System.out.println("Beginning");
		TicsTacsToes game = new TicsTacsToes(kbd, MAX);
		
		game.welcomeMessage();
		do{
		game.gamePlay(kbd, gameboardArray);
		System.out.println("Repeat Game? (y/n): ");
		input = kbd.nextLine();
		repeat = input.charAt(0);
		} while (repeat == 'y' || repeat == 'Y');
		game.goodbyeMessage();
	}
}
		
		


