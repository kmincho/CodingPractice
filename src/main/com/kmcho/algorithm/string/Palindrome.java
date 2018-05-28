package com.kmcho.algorithm.string;

public class Palindrome {
    public static void main(String[] args) {
        testPalindrome("madam");
        testPalindrome("string");
        testPalindrome("abcdcba");
        testPalindrome("abba");
    }

    private static void testPalindrome(String in) {
        System.out.println("(alg2, alg2) -> " + "(" + isPalindrome(in) + ", " + isPalindrome2(in) + ")");
    }

    private static boolean isPalindrome(String in) {
        return in.equals(reverse(in));
    }

    private static String reverse(String in) {
        if (in.length() > 1) {
            return in.charAt(in.length() - 1) + reverse(in.substring(0, in.length() - 1));
        } else {
            return in;
        }
    }

    private static boolean isPalindrome2(String in) {
        int l = 0;
        int h = in.length() - 1;

        while (l < h) {
            if (in.charAt(l++) != in.charAt(h--)) return false;
        }
        return true;
    }
}
