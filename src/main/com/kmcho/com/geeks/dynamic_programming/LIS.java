package com.kmcho.com.geeks.dynamic_programming;

import java.util.Scanner;

/**
 * Longest Increasing Subsequence
 * https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
 *
 * Given a sequence, find the length of the longest increasing subsequence from a given sequence.
 * The longest increasing subsequence means to find a subsequence of a given sequence
 * in which the subsequence's elements are in sorted order, lowest to highest,
 * and in which the subsequence is as long as possible.
 *
 * This subsequence is not necessarily contiguous, or unique.
 *
 * Note: Duplicate numbers are not counted as increasing subsequence.
 *
 * For example:
 * length of LIS for
 * { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
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
