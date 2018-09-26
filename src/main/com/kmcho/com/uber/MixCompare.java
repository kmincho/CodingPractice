package com.kmcho.com.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a comparator that takes two strings and returns a standard integer value:
 *          something negative if the first string is "smaller,"
 *          zero if they are "equal,"
 *          and something positive if the first string is "larger."
 * We want to agree with the standard comparator for all cases except one:
 * if we encounter a consecutive string of integers, we want to read it for its numeric value,
 * and use that as the comparison.
 *
 * For instance, in the standard string comparator, "a10b" comes before "a2b", because 'a' == 'a' and '1' < '2'.
 * In our string ordering, I want to reverse this, instead parsing it so that we see 'a' == 'a', but 10 > 2.
 *
 * a10b < a10c
 * a10b > a2b
 *
 */

class MixCompare {
    public static void main(String[] args) {
        printCompare("a10b", "a2b");        //1
        printCompare("a2b5b", "a2b");       //1
        printCompare("a2b5b", "a2b5b");     //0
        printCompare("a2b6b", "a2b5b");     //1
        printCompare("a2b", "a2b5b");       //-1
        printCompare("a", "b");             //-1
        printCompare("a", "1");             //1
        printCompare("1", "a");             //-1
        printCompare("abc", "a10c");        //1
        printCompare("abc7", "abc9");        //-1
    }

    public static void printCompare(String s1, String s2) {
        System.out.println(s1 + ", " + s2 + " = " + String.valueOf(compare(s1, s2)));
    }

    public static int compare(String s1, String s2) {
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < s1.length() && idx2 < s2.length()) {
            char c1 = s1.charAt(idx1);
            char c2 = s2.charAt(idx2);

            if (!isDigit(c1) && !isDigit(c2)) {
                if (c1 < c2) return -1;
                else if (c1 > c2) return 1;
                idx1++;
                idx2++;
            } else if (isDigit(c1) && !isDigit(c2)) {
                return -1;
            } else if (!isDigit(c1) && isDigit(c2)) {
                return 1;
            } else {
                int num1 = extractNumber(s1, idx1);
                int num2 = extractNumber(s2, idx2);

                if (num1 < num2) return -1;
                else if (num1 > num2) return 1;

                idx1 += String.valueOf(num1).length();
                idx2 += String.valueOf(num2).length();
            }
        }

        if (idx1 < s1.length() || idx2 < s2.length()) {
            if (idx1 < s1.length()) return 1;
            else if (idx2 < s2.length()) return -1;
        }

        return 0;
    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static int extractNumber(String str, int start) {
        int current = start;
        char c = str.charAt(start);
        if (!isDigit(c)) {
            System.out.println("must start from digit");
            return -1;
        }

        while(current < str.length() && isDigit(str.charAt(current))) {
            current++;
        }

        String numberStr = str.substring(start, current);

        return Integer.parseInt(numberStr);
    }

    // I submitted the following codes, which are wrong.
    // I did not understand the problem correctly.
    public static int compare2(String s1, String s2) {
        String[] arr1 = parseString(s1);
        String[] arr2 = parseString(s2);

        int len = arr1.length < arr2.length ? arr1.length : arr2.length;

        for (int i = 0; i < len; i++) {
            try {
                int num1 = Integer.parseInt(arr1[i]);
                int num2 = Integer.parseInt(arr2[i]);

                if (num1 > num2) return 1;
                else if (num1 < num2) return -1;
            } catch (Exception e) {
                if (arr1[i].compareTo(arr2[i]) > 0) {
                    return 1;
                } else if (arr1[i].compareTo(arr2[i]) < 0) {
                    return -1;
                }
            }
        }

        if (arr1.length != arr2.length) {
            if (arr1.length > arr2.length) return 1;
            else return -1;
        }

        return 0;
    }

    public static String[] parseString(String s) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (needToSplit(s.charAt(i - 1), s.charAt(i))) {
                list.add(s.substring(start, i));
                start = i;
            }
        }
        list.add(s.substring(start, s.length()));
        return list.toArray(new String[list.size()]);
    }

    public static boolean needToSplit(char p, char c) {
        return Character.isDigit(p) != Character.isDigit(c);
    }

}

