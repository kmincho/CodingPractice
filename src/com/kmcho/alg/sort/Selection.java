package com.kmcho.alg.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] data = {11, 25, 12, 22, 64};

        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            int value = data[i];
            data[i] = data[minIndex];
            data[minIndex] = value;
        }

        System.out.println(Arrays.toString(data));
    }
}
