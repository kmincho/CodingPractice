package com.kmcho.com.geeks_for_geeks.divide_and_conquer.merge_sort;

import java.util.Scanner;

public class MergeSort {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void mergeSort(int arr[], int l, int r) {
        GfG g = new GfG();
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            g.merge(arr, l, m, r);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            MergeSort ms = new MergeSort();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
//            GfG g = new GfG();
            mergeSort(arr, 0, arr.length - 1);
            ms.printArray(arr);
            T--;
        }
    }
}

