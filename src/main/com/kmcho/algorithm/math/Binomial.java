package com.kmcho.algorithm.math;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 *
 * A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order,
 * that k objects can be chosen from among n objects;
 * more formally, the number of k-element subsets (or k-combinations) of an n-element set.
 *
 * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k).
 * For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 */

public class Binomial {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt() + 1;

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
