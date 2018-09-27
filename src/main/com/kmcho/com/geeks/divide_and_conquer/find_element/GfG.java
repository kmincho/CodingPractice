package com.kmcho.com.geeks.divide_and_conquer.find_element;

import java.util.Scanner;

/**
 * K-th element of two sorted Arrays
 * https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array/0
 */

public class GfG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            int[] arr_n = new int[n];
            int[] arr_m = new int[m];

            for (int j = 0; j < n; arr_n[j++] = scanner.nextInt()) ;
            for (int j = 0; j < m; arr_m[j++] = scanner.nextInt()) ;

            int p = 0;
            int q = 0;
            int r = 1;
            int v;

            while (p < n || q < m) {
                if (p < n && q < m) {
                    v = arr_n[p] < arr_m[q] ? arr_n[p++] : arr_m[q++];
                } else {
                    v = p < n ? arr_n[p++] : arr_m[q++];
                }
                if (r++ == k) System.out.println(v);
            }
        }
    }
}
