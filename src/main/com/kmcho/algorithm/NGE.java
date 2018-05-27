package com.kmcho.algorithm;

import java.util.Stack;

/**
 *  https://www.geeksforgeeks.org/next-greater-element/
 */

public class NGE {
    public static void main(String[] args) {
        int[] input = {4, 5, 2, 25};
//        int[] input = {13, 7, 6, 12};
//        int[] input = {2, 5, 4, 3, 1, 9};

        solutionBest(input);
    }

    static void solutionBest(int[] input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(input[0]);

        int next;
        for (int i = 1; i < input.length; i++) {
            next = input[i];

            while(!stack.isEmpty()) {
                int value = stack.pop();
                if (value < next) {
                    System.out.println(value + " --> " + next);
                } else {
                    stack.push(value);
                    break;
                }
            }

            stack.push(next);
        }

        next = -1;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.println(value + " --> " + next);
        }
    }

    static void solution2(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int nextGreater = -1;
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] < input[j]) {
                    nextGreater = input[j];
                    break;
                }
            }
            System.out.println(input[i] + " --> " + nextGreater);
        }
    }

    static void solution1(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int nextGreater = -1;
            for (int j = input.length - 1; j > i; j--) {
                if (input[i] < input[j]) {
                    nextGreater = input[j];
                }
            }
            System.out.println(input[i] + " --> " + nextGreater);
        }
    }
}
