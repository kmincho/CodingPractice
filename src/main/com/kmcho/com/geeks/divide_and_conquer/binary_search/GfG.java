package com.kmcho.com.geeks.divide_and_conquer.binary_search;

import java.util.Scanner;

/**
 * Binary Search
 * https://practice.geeksforgeeks.org/problems/binary-search/1
 */

public class GfG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[] array = new int[size];

            for (int j = 0; j < size; j++) {
                array[j] = scanner.nextInt();
            }

            int k = scanner.nextInt();

            int result = bin_search(array, 0, array.length - 1, k);
            System.out.println(result);
        }
    }

    static int bin_search(int A[], int left, int right,  int k) {
        int center = (left + right) / 2;

        if (left == right) {
            return A[center] == k ? center : -1;
        }

        if (k == A[center]) {
            return center;
        } else if (k < A[center]) {
            return bin_search(A, left, center - 1, k);
        } else if (k > A[center]) {
            return bin_search(A, center + 1, right, k);
        }

        return -1;
    }
}
