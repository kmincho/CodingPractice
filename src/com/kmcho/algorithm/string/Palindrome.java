package com.kmcho.algorithm.string;

public class Palindrome {
    public static void main(String[] args) {
        String str = "madam";
        System.out.println(str + ", panlindrome? " + isPalindrome(str));
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
}
