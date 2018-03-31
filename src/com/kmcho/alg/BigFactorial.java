package com.kmcho.alg;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/factorial-large-number/
 */

public class BigFactorial {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long value = scanner.nextLong();

        BigInteger result = BigInteger.ONE;

        for (long i = 1; i < value + 1; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }
}
