package com.kmcho.java.collection;

import java.util.*;

import static com.kmcho.java.collection.PrintList.printList3;

public class VectorPractice {
    public static void main(String[] args) {
        vectorPractice();
    }

    private static void vectorPractice() {
        Vector v = new Vector(Arrays.asList(1, 2, "Tiger"));
        v.add(5);
        v.add("Lion");

        printList3(v);
        System.out.println("element (idx = 2) in vector = " + v.get(2));
        System.out.println("vector size = " + v.size());
        System.out.println("vector capacity = " + v.capacity());
    }
}
