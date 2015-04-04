package square;
/*
 * Square Interview Coding Questions:
 * Implement Tic-Tac-Toe
 */

import java.util.Scanner;

public class TicTacToe {
	static int[][] board = { 	{ 0,  0,  0},
								{ 0,  0,  0},
								{ 0,  0,  0}};
//	static int[][] board = { 	{ 1,  1,  0},
//								{ -1,  -1,  0},
//								{ 0,  0,  0}};
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
			printBoard();
			String whosTurn = turn ? "A" : "B";
			System.out.println(whosTurn + "'s turn");
			input = scanner.nextLine();
			tokens = input.split(",");
			pos[0] = Integer.valueOf(tokens[0]);
			pos[1] = Integer.valueOf(tokens[1]);
			board[pos[0]][pos[1]] = turn ? 1 : -1;
			turn = !turn;
			if ((winner = checkWinner(pos)) != 0) {
				printBoard();
			    if (winner == 1) {
			        System.out.println("WINNER : A");
			    } else {
			        System.out.println("WINNER : B");
			    }
			    break;
			}
		}
		scanner.close();
		if (winner == 0) {
			System.out.println("Tie");
		} else {
			System.out.println(winner == 1 ? "A" : "B");
		}
	}

    public static int checkWinner(int[] pos) {
        boolean checkResult = true;
        int k;
        
        //given a column, check every row
		checkResult = false;
		k = pos[0];
		int j;
		for (j = 0; j < 2; j++) {
			if (board[k][j] != board[k][j + 1]) {
				break;
			}
		}
		if (j == 2) {
			checkResult = true;
		}
        
        //given a row, check every column
		if (!checkResult) {
			k = pos[1];
			for (j = 0; j < 2; j++) {
				if (board[j][k] != board[j + 1][k]) {
					break;
				}
			}
			if (j == 2) {
				checkResult = true;
			}
		}

		//check diagonal
		if (!checkResult) {
			if (pos[0] == pos[1]) {
				for (j = 0; j < 2; j++) {
					if (board[j][j] != board[j + 1][j + 1]) {
						break;
					}
				}
				
			} else if (pos[0] + pos[1] == 2) {
				for (j = 0; j < 2; j++) {
					if (board[j][2 - j] != board[j + 1][1 - j]) {
						break;
					}
				}
			}
			if (j == 2) {
				checkResult = true;
			}
		}
		if (checkResult) {
			return board[pos[0]][pos[1]];
		}

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
