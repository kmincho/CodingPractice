package com.kmcho.com.geeks_for_geeks.divide_and_conquer.find_single;

import java.util.Scanner;

/**
 *  Find the element that appears once in sorted array
 *  https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array/0
 */

class GfG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scanner.nextInt();
            }

            for (int k = 0; k < size; k += 2) {
                if (k + 1 >= size || arr[k] != arr[k + 1]) {
                    System.out.println(arr[k]);
                    break;
                }
            }
        }
    }
}
