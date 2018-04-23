package com.kmcho.com.geeks_for_geeks.backtracking.knight_tour;

/**
 * The Knight’s tour problem
 * https://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 */

public class KnightTour {
    private static int BOARD_SIZE = 8;
    private static int BOARD_SIZE_ALL = BOARD_SIZE * BOARD_SIZE;
    private static int[] rowMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static int[] colMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) {
        int[][] solution = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE_ALL; i++)
            solution[i / BOARD_SIZE][i % BOARD_SIZE] = -1;

        if (knightTour(solution, 0, 0, 0)) printSolution(solution);
        else System.out.println("no solution !!!");
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(String.format("%3s ", board[i][j]));
            }
            System.out.println();
        }
    }

    private static boolean knightTour(int[][] solution, int step, int row, int col) {
        solution[row][col] = step;
        if (step >= BOARD_SIZE_ALL - 1) return true;

        int nextRow;
        int nextCol;

        for (int i = 0; i < 8; i++) {
            nextRow = row + rowMove[i];
            nextCol = col + colMove[i];

            if (nextRow >= 0 && nextCol >= 0 && nextRow < BOARD_SIZE && nextCol < BOARD_SIZE) {
                if (solution[nextRow][nextCol] == -1) {
                    if (knightTour(solution, step + 1, nextRow, nextCol)) {
                        return true;
                    }
                }
            }
        }

        solution[row][col] = -1;

        return false;
    }
}
