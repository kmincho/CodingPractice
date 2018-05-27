package com.kmcho.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/lonely-integer/problem
 */

public class LonelyInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] v = new int[size];

        for (int i = 0; i < size; i++) {
            v[i] = scanner.nextInt();
        }

        int result = findLonelyInteger3(v);
        System.out.println(result);
    }

    static int findLonelyInteger3(int[] v) {
        int result = 0;

        for (int i = 0; i < v.length; i++) {
            result ^= v[i];
        }

        return result;
    }

    static int findLonelyInteger2(int[] v) {
        long a, b;
        long aa = 0;
        long bb = 0;

        int tt;

        for (int i = 0; i < v.length; i++) {
            int t = v[i];
            if (t >= 64) {
                t -= 64;
                b = 1 << t;
                bb = (bb & ~b) | ((bb & b) ^ b);
            } else {
                a = 1 << t;
                aa = (aa & ~a) | ((aa & a) ^ a);
            }

            System.out.println(bb + " " + aa);
        }

        int bp = bb > 0 ? getSetBitPosition(bb) + 64 : 0;
        int ap = aa > 0 ? getSetBitPosition(aa) : 0;
        tt = bp + ap;

        return tt;
    }

    static int getSetBitPosition(long x) {
        for (int i = 0; i < 64; i++) {
            if (x == 1) return i;
            x = x >> 1;
        }
        return 0;
    }

    static int findLonelyInteger(int[] v) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.of(v).forEach(i -> {
                if (map.get(i) == null) map.put(i, i);
                else map.remove(i);
            }
        );

        if (map.size() == 1) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                return entry.getValue();
            }
        }

        return Integer.MIN_VALUE;
    }

}
