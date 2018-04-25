package com.kmcho.algorithm.string;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Determine if a string has all Unique Characters
 *
 * Given a string, Determine if the string has all unique characters.
 * https://www.geeksforgeeks.org/determine-string-unique-characters/
 *
 * Input : abcd10jk
 * Output : true
 *
 * Input : hutg9mnd!nk9
 * Output : false
 */


/**
 * Using HashMap is not a good idea.
 * If we want to use extra data structure, using array is good enough.
 */
public class UniqueCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(checkUnique(str.toCharArray()));
    }

    public static boolean checkUnique(char[] str) {
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            if (h.get(Integer.valueOf(str[i])) != null) {
                return false;
            }

            h.put(Integer.valueOf(str[i]), 1);
        }
        return true;
    }
}
