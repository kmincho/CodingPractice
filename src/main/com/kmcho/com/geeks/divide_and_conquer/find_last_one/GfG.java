package com.kmcho.com.geeks.divide_and_conquer.find_last_one;

import java.util.Scanner;

/**
 * Last index of One
 * https://practice.geeksforgeeks.org/problems/last-index-of-1/0 *
 */

public class GfG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            int result = findOne(str, 0, str.length() - 1);
            System.out.println(result);
        }
    }

    private static int findOne(String str, int l, int h) {
        if (l > h) return -1;

        if (str.charAt(h) == '1') return h;

        if (l < h) {
            int m = (l + h) / 2;
            int p = findOne(str, l, m);
            int q = findOne(str, m + 1, h);
            return p > q ? p : q;
        }

        return -1;
    }
}
