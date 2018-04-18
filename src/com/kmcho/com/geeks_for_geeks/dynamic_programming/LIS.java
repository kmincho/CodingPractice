package com.kmcho.com.geeks_for_geeks.dynamic_programming;

import java.util.Scanner;

/**
 * Longest Increasing Subsequence
 * https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
 */

public class LIS {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int numTest = scanner.nextInt();

        for (int t = 0; t < numTest; t++) {
            int n = scanner.nextInt();
            int[] seq = new int[n];

            for (int i = 0; i < n; i++) {
                seq[i] = scanner.nextInt();
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, find(n, seq, i, new int[n][n]));
            }

            System.out.println(max);
        }
    }

    private static int find(int n, int[] seq, int start, int[][] count) {
        int max = 1;
        for (int next = start + 1; next < n; next++) {
            int cnt;
            if (seq[start] < seq[next]) {
                if (count[start][next] != 0) {
                    cnt = count[start][next];
                } else {
                    cnt = find(n, seq, next, count) + 1;
                    count[start][next] = cnt;
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}
