/*
 * Square Interview Coding Questions:
 * Implement Tic-Tac-Toe
 */

import java.util.Scanner;

public class TicTacToe {
	static int[][] board = { {0, 0, 0},
						{0, 0, 0},
						{0, 0, 0}};
	public static void main(String[] args) {
		int winner = 0;
		Scanner scanner = new Scanner(System.in);
		String input;
		int[] pos = new int[2];
		String[] tokens;
		boolean turn = true;
		int maxTurn = 9;
		int curTurn = 0;
		while(curTurn < maxTurn) {
			String whosTurn = turn ? "A" : "B";
			System.out.println(whosTurn + "'s turn");
			input = scanner.nextLine();
			tokens = input.split(",");
			pos[0] = Integer.valueOf(tokens[0]);
			pos[1] = Integer.valueOf(tokens[1]);
			board[pos[0]][pos[1]] = turn ? 1 : -1;
			System.out.println("x = " + pos[0] + ", y = " + pos[1]);
			turn = !turn;
			printBoard();
			checkWinner(pos);
		}
		if (winner == 0) {
			System.out.println("Tie");
		} else {
			System.out.println(winner == 1 ? "A" : "B");
		}
	}
	
	public static int checkWinner(int[] pos) {
		//TO-DO: I need to implement this function
		return 0;
	}
	
	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			String str = 
					String.format("%2d %2d %2d", board[i][0], board[i][1], board[i][2]);
			System.out.println(str);
		}
		
	}
}
