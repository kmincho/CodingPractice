package com.kmcho.algorithm.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] data = {11, 8, 25, 12, 22, 64, 13};

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j+1);
                }
            }
        }

        System.out.println(Arrays.toString(data));
    }

    static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
}
