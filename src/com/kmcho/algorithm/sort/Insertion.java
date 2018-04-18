package com.kmcho.algorithm.sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] data = {11, 8, 25, 12, 22, 64, 13};

        for (int i = 1; i < data.length; i++) {
            int current = data[i];

            for (int j = i - 1; j >= 0; j--) {
                if (data[j] < current) {
                    data[j + 1] =  current;
                    break;
                } else {
                    data[j + 1] =  data[j];
                    if (j == 0) {
                        data[0] = current;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(data));
    }
}
