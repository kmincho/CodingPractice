package com.kmcho.com.geeks_for_geeks.divide_and_conquer.quick_sort;

import java.util.Scanner;

public class QuickSort {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /* The main function that implements QuickSort()
       arr[] --> Array to be sorted,
       low  --> Starting index,
       high  --> Ending index */
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            GfG g = new GfG();
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = g.partition(arr, low, high);
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Driver program
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            QuickSort qs = new QuickSort();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            GfG g = new GfG();
            qs.quickSort(arr, 0, n - 1);
            qs.printArray(arr);
            T--;
        }
    }
}
