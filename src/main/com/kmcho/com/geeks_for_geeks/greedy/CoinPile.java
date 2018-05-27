package com.kmcho.com.geeks_for_geeks.greedy;

import java.util.Scanner;

/**
 * Coin Piles
 * https://practice.geeksforgeeks.org/problems/coin-piles/0
 *
 * There are N piles of coins each containing  Ai (1<=i<=N) coins.
 * Now, you have to adjust the number of coins in each pile
 * such that for any two pile, if a be the number of coins in first pile
 * and b is the number of coins in second pile then |a-b|<=K.
 * In order to do that you can remove coins from different piles to decrease the number of coins in those piles
 * but you cannot increase the number of coins in a pile by adding more coins.
 * Now, given a value of N and K, along with the sizes of the N different piles
 * you have to tell the minimum number of coins to be removed in order to satisfy the given condition.
 *
 * Note: You can also remove a pile by removing all the coins of that pile.
 */

public class CoinPile {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int numTest = scanner.nextInt();

        for (int t = 0; t < numTest; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] piles = new int[n];

            for (int i = 0; i < n; i++) {
                piles[i] = scanner.nextInt();
            }

            adjustCoinPiles(n, k, piles);
        }
    }

    private static void adjustCoinPiles(int n, int k, int[] piles) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int cost = 0;

            for (int j = 0; j < n; j++) {
                if (piles[j] < piles[i]) {
                    cost += piles[j];
                } else {
                    if (piles[j] - piles[i] > k) {
                        cost += piles[j] - piles[i] - k;
                    }
                }
            }

            if (cost < result) result = cost;
        }

        System.out.println(result);
    }
}
