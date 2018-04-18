package com.kmcho.algorithm.sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] data = {11, 8, 25, 12, 22, 64, 13};

        quickSort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
    }

    static void quickSort(int[] data, int left, int right) {
        int i;
        int j;
        int pivot;

        if (left < right) {
            i = left;
            j = right;
            pivot = data[left];

            while (i < j) {
                while(data[j] > pivot) {
                    j--;
                }

                while(i < j && data[i] <= pivot) {
                    i++;
                }

                swap(data, i, j);
            }

            data[left] = data[i];
            data[i] = pivot;

            quickSort(data, left, i - 1);
            quickSort(data, i + 1, right);
        }
    }

    static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
}
