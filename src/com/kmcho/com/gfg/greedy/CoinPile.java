package com.kmcho.com.gfg.greedy;

import java.util.Arrays;
import java.util.Scanner;

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
