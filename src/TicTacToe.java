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
			if ((winner = checkWinner(pos)) != 0) {
			    if (winner == 1) {
			        System.out.println("WINNER : A");
			    } else {
			        System.out.println("WINNER : B");
			    }
			    break;
			}
		}
		if (winner == 0) {
			System.out.println("Tie");
		} else {
			System.out.println(winner == 1 ? "A" : "B");
		}
	}

    public static int checkWinner(int[] pos) {
        // TO-DO: I need to implement this function
        boolean checkResult = true;
        if (pos[0] == 0 || pos[0] == 2) {
            checkResult = true;
            int k = pos[0];
            int j;
            for (j = 0; j < 2; j++) {
                System.out.println("b1 = " + board[j][k] + ", b2 = " + board[j+1][k]);
                if (board[j][k] != board[j + 1][k]) {
                    checkResult = false;
                    break;
                }
            }
            if (checkResult) {
                System.out.println("11111 - " + j);
                return board[pos[0]][pos[1]];
            }
        }
        if (pos[1] == 0 || pos[1] == 2) {
            checkResult = true;
            int k = pos[1];
            for (int j = 0; j < 2; j++) {
                if (board[k][j] != board[k][j + 1]) {
                    checkResult = false;
                    break;
                }
            }
            if (checkResult) {
                System.out.println("22222");
                return board[pos[0]][pos[1]];
            }
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
