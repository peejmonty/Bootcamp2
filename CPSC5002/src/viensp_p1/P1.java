package viensp_p1;

public class P1 {

	public static void main(String[] args) {
		
		final int MAX = 3;
		int row;
		int col;
		String[] players = players();
		
		TicTacToe game = new TicTacToe(players);
		//TicTacToe.displayGameBoard(MAX, playsArray);
		//row = playerX.row();
		//row = playerO.row();
		//TicTacToe.displayGameBoard();
		
	}
		
		public static String[] players() {
			final int MAX = 2;
			String[] players = new String[MAX];
			
			players[0] = "X";
			players[1] = "O";
			
			return players;
			
		}
		
		

}
