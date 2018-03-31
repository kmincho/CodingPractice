package com.kmcho.alg;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ArraySum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  scanner.nextInt();
        }

        System.out.println(IntStream.of(arr).sum());
    }
}
