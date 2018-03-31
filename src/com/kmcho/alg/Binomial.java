package com.kmcho.alg;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 */

public class Binomial {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i-1][j];
                }
            }

            IntStream.of(arr[i]).limit(i + 1).mapToObj(v -> new String(v + " ")).forEach(System.out::print);
            System.out.println();
        }
    }
}
