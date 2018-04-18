package com.kmcho.com.cracking_the_coding_interview.chapter01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println(isUnique(input));

    }

    // if we assume input string has lower case 'a' to 'z'
    // O(n), but very small space
    static boolean isUnique(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); i++) {
            int value = 1 << (input.charAt(i) - 'a');
            if ((value & checker) != 0) {
                return false;
            } else {
                checker |= value;
            }
        }
        return true;
    }

    // O(n), but cannot guarantee unique hashcode for each character
    static boolean isUnique2(String input) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (map.get(input.charAt(i)) == null) {
                map.put(input.charAt(i), input.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    // O(n^2)
    static boolean isUnique3(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) return false;
            }
        }
        return true;
    }
}
