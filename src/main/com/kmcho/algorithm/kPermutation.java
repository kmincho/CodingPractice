package com.kmcho.algorithm;

/**
 * https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 *
 * Given an array of size n,
 * generate and print all possible combinations of r elements in array.
 * For example, if input array is {1, 2, 3, 4} and r is 2,
 * then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
 */

public class kPermutation {
    public static void main(String[] args) {
        String[] input = {"a", "b", "c", "d", "e", "f", "g"};
        int k = 2;

        permutation(input, new String(), k);

    }

    static void permutation(String[] array, String output, int k) {
        int size = array.length;

        if (k == 0) {
            System.out.println(output);
            return;
        }

        for (int i = 0; i < size; i++) {
            String[] input = getArrayRemoved(array, array[i]);
            String output2;

            if (output.isEmpty()) {
                output2 = new String(array[i]);
            } else {
                output2 = new String(output + ", " + array[i]);
            }

            permutation(input, output2, k - 1);

        }
    }

    static String[] getArrayRemoved(String[] input, String removed) {
        String[] result = new String[input.length - 1];

        int i = 0;
        for (String s : input) {
            if (!s.equals(removed)) {
                result[i++] = s;
            }
        }

        return result;
    }
}
