package com.kmcho.alg;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two/
 */

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("is power of two? " + isPowerOfTwo(n));
        System.out.println("is power of two? " + isPowerOfTwo_2(n));
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;

        while (n != 1) {
            if (n % 2 != 0) return false;
            n >>= 1;
        }

        return true;
    }

    public static boolean isPowerOfTwo_2(int x) {
        if (x == 1) return true;
        if (x <= 0) return false;
        x = x & (x - 1);
        return x == 0;
    }
}
