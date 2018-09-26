package com.kmcho.com.uber;

public class Sudoku {

    //valid
    public static final int[][] BOARD_EMPTY_GOOD = new int[9][9];

    //valid with zeros
    public static final int[][] BOARD_VALID_INCOMPLETE = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 0, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 0, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {2, 3, 4, 0, 6, 7, 0, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 0, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
            {3, 4, 5, 6, 7, 8, 0, 1, 2}
    };

    public static final int[][] BOARD_INVALID_INCOMPLETE = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 0, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 0, 0, 6},
            {0, 8, 1, 2, 3, 4, 5, 6, 7},
            {2, 3, 4, 0, 6, 7, 0, 9, 1},
            {0, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 0, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
            {3, 4, 5, 6, 7, 8, 0, 1, 2}
    };

    // Test Executor
    public static void main(String[] args) {
        int[][] board = BOARD_INVALID_INCOMPLETE;

        if (checkValid(board)) {
            System.out.println(isValid(board));
        } else {
            System.out.println("This is not valid Sudoku");
        }
    }

    public static boolean isValid(int[][] board) {
        //TODO return whether board is valid
        //   throw new RuntimeException("TODO");

        //check every rows
        for (int i = 0; i < 9; i++) {
            if (!isAllUnique(board[i])) {
                System.out.println("row " + i + " is wrong");
                return false;
            }
        }

        //check every columns
        for (int i = 0; i < 9; i++) {
            int[] col = new int[9];
            for (int j = 0; j < 9; j++) {
                col[j] = board[j][i];
            }
            if (!isAllUnique(col)) {
                System.out.println("col " + i + " is wrong");
                return false;
            }
        }

        //check every rectangles
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] rec = flatten(board, i * 3, j * 3);

                if (!isAllUnique(rec)) {
                    System.out.println("rectangle (" + i + ", " + j + ") is wrong");
                    return false;
                }
            }
        }

        return true;
    }

    private static int[] flatten(int[][] rec, int x, int y) {
        int size = 3;
        int[] ret = new int[size * size];
        int k = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                ret[k++] = rec[i][j];
            }
        }

        return ret;
    }

    private static boolean checkValid(int[][] array) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j] < 0 || array[i][j] > 9) return false;
            }
        }
        return true;
    }

    private static boolean isAllUnique(int[] array) {
        int[] mark = new int[10];

        for (int i = 0; i < 9; i++) mark[i] = 0;

        for (int i = 0; i < 9; i++) {
            if (array[i] == 0) continue;

            if (mark[array[i]] == 0) {
                mark[array[i]] = 1;
            } else {
                return false;
            }
        }
        return true;
    }

}
