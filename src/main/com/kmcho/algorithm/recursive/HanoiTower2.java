package com.kmcho.algorithm.recursive;

public class HanoiTower2 {
    public static void main(String args[]) {
        int num = 3;
        move(num, 1, 3, 2);

    }

    private static void move(int num, int start, int end, int temp) {
        if (num == 1) {
            System.out.println(start + " -> " + end);
            return;
        }

        move(num - 1, start, temp, end);
        move(1, start, end, temp);
        move(num - 1, temp, end, start);
    }
}
