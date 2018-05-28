package com.kmcho.algorithm.string;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        testAnagram("listen", "silent");
        testAnagram("triangle", "integral");
    }

    private static void testAnagram(String s1, String s2) {
        System.out.println("(algorithm1, algorithm2) -> (" + areAnagram(s1, s2) + ", " + areAnagram2(s1, s2) + ")");
    }

    // O(nlogn)
    private static boolean areAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) return false;
        }
        return true;
    }

    // O(n)
    private static boolean areAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        final int NUM_CHAR = 256;

        int[] charCount1 = new int[NUM_CHAR];
        int[] charCount2 = new int[NUM_CHAR];

        Arrays.fill(charCount1, 0);
        Arrays.fill(charCount2, 0);

        for (int i = 0; i < str1.length; i++) {
            charCount1[str1[i]]++;
            charCount2[str2[i]]++;
        }

        for (int i = 0; i < str1.length; i++) {
            if (charCount1[i] != charCount2[2]) return false;
        }

        return true;
    }
}
