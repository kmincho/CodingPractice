package com.kmcho.algorithm.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] data = {11, 25, 12, 22, 64};

        sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) swap(data, i, j);
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
