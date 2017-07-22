package viensp_p1;

public class P1 {

	public static void main(String[] args) {
		
		final int MAX = 3;
		int row;
		int col;
		
		String PlayerX = "X";
		String PlayerO = "O";
		
		TicTacToe playerX = new TicTacToe(MAX, PlayerX);
		TicTacToe playerO = new TicTacToe(MAX, PlayerO);
		//TicTacToe.displayGameBoard(MAX, playsArray);
		row = playerX.row();
		row = playerO.row();
		
		

	}

}
