package com.kmcho.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/factorial-large-number/
 */

public class BigFactorial {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long value = scanner.nextLong();

        System.out.println(factorial(BigInteger.valueOf(value)));
    }

    private static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while(!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }
}
