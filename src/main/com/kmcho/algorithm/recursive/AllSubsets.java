package com.kmcho.algorithm.recursive;

import java.util.Objects;
import java.util.stream.Stream;

public class AllSubsets {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        printAllSubsets(array);
    }

    private static void printAllSubsets(int[] array) {
        Integer[] subset = new Integer[array.length];
        findAllSubsets(array, subset, 0);
    }

    private static void findAllSubsets(int[] array, Integer[] subset, int i) {
        if (i >= array.length) {
            printSubset(subset);
        } else {
            subset[i] = null;
            findAllSubsets(array, subset, i + 1);

            subset[i] = array[i];
            findAllSubsets(array, subset, i + 1);
        }
    }

    private static void printSubset(Integer[] subset) {
        Stream.of(subset).filter(Objects::nonNull).map(v -> v + ", ").forEach(System.out::print);
        System.out.println();
    }
}
