package com.kmcho.com.geeks_for_geeks.backtracking;

import java.util.Scanner;

/**
 * N-Queen Problem
 * https://practice.geeksforgeeks.org/problems/n-queen-problem/0
 */

public class NQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int t = 0; t < tc; t++) {
            int size = scanner.nextInt();
            int[][] board = new int[size][size];

            if (placeQueue(board, 0)) System.out.println();
            else System.out.println("-1");
        }
    }

    private static boolean placeQueue(int[][] board, int col) {
        int size = board.length;
        if (col >= size) {
            printResult(board);
            return true;
        }

        boolean result = false;
        for (int row = 0; row < size; row++) {
            if (valid(board, row, col)) {
                board[row][col] = 1;
                result |= placeQueue(board, col + 1);
                board[row][col] = 0;
            }
        }
        return result;
    }

    private static int[] vr = {-1, -1, 1, 1};
    private static int[] vc = {-1, 1, 1, -1};

    private static boolean valid(int[][] board, int row, int col) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (i != col && board[row][i] == 1) return false;
        }

        for (int i = 0; i < size; i++) {
            if (i != row && board[i][col] == 1) return false;
        }
        int r;
        int c;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < size; j++) {
                r = row + vr[i] * (j + 1);
                c = col + vc[i] * (j + 1);

                if (r < 0 || r >= size) continue;
                if (c < 0 || c >= size) continue;

                if (board[r][c] == 1) return false;
            }
        }
        return true;
    }

    private static void printResult(int[][] board) {
        System.out.print("[");
        for (int col = 0; col < board.length; col++) {
            boolean check = false;
            for (int row = 1; row < board.length + 1; row++) {
                if (board[row - 1][col] == 1) {
                    check = true;
                    System.out.print(row + " ");
                    continue;
                }
            }
            if (!check) System.out.print("0");
        }
        System.out.print("] ");
    }
}
