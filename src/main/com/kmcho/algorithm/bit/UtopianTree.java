package com.kmcho.algorithm.bit;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 *
 * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. Each summer, its height increases by 1 meter.
 * Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring. How tall will her tree be after  growth cycles?
 * For example, if the number of growth cycles is, the calculations are as follows:
 *
 * Period  Height
 * 0          1
 * 1          2
 * 2          3
 * 3          6
 * 4          7
 * 5          14
 */
public class UtopianTree {
    static int utopianTree(int n) {
        return (1 << (n + 1) / 2 + 1) - 1 - n % 2;
//        return ~(~1 << ((n + 1) >> 1)) - n % 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int result = utopianTree(n);
            System.out.println(result);
        }
        in.close();
    }
}
