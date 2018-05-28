package com.kmcho.algorithm.sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] data = {11, 8, 25, 12, 22, 64, 13};

        quickSort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start < end) {
            int m = partition2(data, start, end);
            quickSort(data, start, m - 1);
            quickSort(data, m + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        int i = start;
        int j = end;
        int pivot = data[start];

        while (i < j) {
            while(data[j] > pivot) {
                j--;
            }

            while(i < j && data[i] <= pivot) {
                i++;
            }

            swap(data, i, j);
        }

        data[start] = data[i];
        data[i] = pivot;

        return i;
    }

    private static int partition2(int[] data, int start, int end) {
        int pivot = end;
        int i = start;
        int j = start;

        while (j < end) {
            if (data[j] < data[pivot]) {
                swap(data, i++, j);
            }
            j++;
        }
        swap(data, i, pivot);
        return i;
    }

    private static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
}
