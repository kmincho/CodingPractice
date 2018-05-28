package com.kmcho.algorithm.sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] data = {11, 8, 25, 12, 22, 64, 13};

        sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j - 1] < data[j]) break;
                swap(data, j, j - 1);
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
